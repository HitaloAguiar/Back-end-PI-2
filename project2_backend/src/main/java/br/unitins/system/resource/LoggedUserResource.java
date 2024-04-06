package br.unitins.system.resource;


import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.system.dto.NewPasswordDTO;
import br.unitins.system.dto.UpdateUserDataDTO;
import br.unitins.system.model.User;
import br.unitins.system.service.JwtService;
import br.unitins.system.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.Produces;

@Path("/perfil")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoggedUserResource {
    

    @Inject 
    UserService userService;

    @Inject
    JsonWebToken tokenJwt;

    @Inject
    JwtService jwtService;


    @GET
    @Path("/personal-information")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public User getPesonalData() {

        return userService.getById(jwtService.getUserId(tokenJwt));
    }


    @PUT
    @Path("/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response updateAllPersonalData(User user) throws NotFoundException {
        userService.update(jwtService.getUserId(tokenJwt), user);

        return Response
                .status(Status.CREATED)
                .build();
    }

    @PATCH
    @Path("/password")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response updateSenha(NewPasswordDTO passwordDTO) {

        User user = userService.getById(jwtService.getUserId(tokenJwt));

        try {

            userService.update(user.getIdUser(), passwordDTO);

            return Response.status(Status.NO_CONTENT).build();

        } catch (NotAuthorizedException e) {

            return Response
                    .status(Status.FORBIDDEN)
                    .entity(e.getChallenges())
                    .build();
        }
    }

    @PATCH
    @Path("/user/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response updateUserPersonalData(UpdateUserDataDTO user) throws NotFoundException {
        userService.update(jwtService.getUserId(tokenJwt), user);

        return Response
                .status(Status.CREATED)
                .build();
    }

}
