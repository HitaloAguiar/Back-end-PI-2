package br.unitins.system.resource;

import java.util.List;

import br.unitins.system.model.User;
import br.unitins.system.service.UserService;
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
    UserService userService;

    @GET
    public List<User> getAll() {

        return userService.getAll();
    }

    @GET
    @Path("/{id}")
    public User getById(@PathParam("id") Long id) throws NotFoundException {

        return userService.getById(id);
    }

    @POST
    public Response insert(User user) {

        userService.insert(user);

        return Response
                .status(Status.CREATED) // 201
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, User user) throws NotFoundException {

        userService.update(id, user);

        return Response
                .status(Status.CREATED) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        userService.delete(id);

        return Response
                    .status(Status.NO_CONTENT)
                    .build();
    }
}
