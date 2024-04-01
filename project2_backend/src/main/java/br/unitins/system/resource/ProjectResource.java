package br.unitins.system.resource;

import java.util.List;

import br.unitins.system.model.User;
import br.unitins.system.service.ProjectService;
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

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectResource {
    @Inject
    private ProjectService projectService;

    @GET
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public List<Object> getAll() {
        return projectService.getAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Object getById(@PathParam("id") Long id) throws NotFoundException {
        return projectService.getById(id);
    }

    @POST
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response insert(Object user) {
        projectService.insert(user);

        return Response
                .status(Status.CREATED) // 201
                .build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response update(@PathParam("id") Long id, User user) throws NotFoundException {
        projectService.update(id, user);

        return Response
                .status(Status.CREATED) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {
        projectService.delete(id);

        return Response
                    .status(Status.NO_CONTENT)
                    .build();
    }

    @POST
    @Path("/item/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response addItem(@PathParam("id") Long id, Object itemProject) throws IllegalArgumentException, NotFoundException {
        projectService.addItemIntoProject(id, itemProject);

        return Response
                    .status(Status.NO_CONTENT)
                    .build();
    }

    @DELETE
    @Path("/item/{id}")
    @RolesAllowed({"Admin", "Funcionario", "Cliente"})
    public Response removeItem(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {
        projectService.removeItemProject(id);

        return Response
                    .status(Status.NO_CONTENT)
                    .build();
    }
}
