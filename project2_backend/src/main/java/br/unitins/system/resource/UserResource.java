package br.unitins.system.resource;

import java.util.List;

import br.unitins.system.model.User;
import br.unitins.system.service.JwtService;
import br.unitins.system.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    JwtService jwtService;

    @Inject
    UserService userService;

    @GET
    @RolesAllowed("Cliente")
    public List<User> getAll() {

        return userService.getAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public User getById(@PathParam("id") Long id) throws NotFoundException {
        return userService.getById(id);
    }

    @POST
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response insert(User user) {

        userService.insert(user);

        return Response
                .status(Status.CREATED) // 201
                .build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response update(@PathParam("id") Long id, User user) throws NotFoundException {

        userService.update(id, user);

        return Response
                .status(Status.CREATED) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        userService.delete(id);

        return Response
                    .status(Status.NO_CONTENT)
                    .build();
    }
}
