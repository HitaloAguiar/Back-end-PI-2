package br.unitins.system.resource;

import br.unitins.system.dto.AuthDTO;
import br.unitins.system.model.User;
import br.unitins.system.repository.UserRepository;
import br.unitins.system.service.JwtService;
import br.unitins.system.service.PasswordService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {
    @Inject
    UserRepository repository;

    @Inject
    PasswordService pService;

    @Inject
    JwtService jwtService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@Valid AuthDTO user) {
        String hash = pService.getHash(user.getPassword());

        User validUser = repository.findByEmailAndPassword(user.getEmail(), hash);

        if (validUser == null){
            return Response
                .status(204)
                .entity("Usuário não encontrado.")
                .build();
        } else {
            return Response.noContent().header(
                "Authorization",
                jwtService.generateJwt(validUser)
            ).build();
        }
    }
}
