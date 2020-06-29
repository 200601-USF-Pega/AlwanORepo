package project1.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import project1.dao.IProjectRepo;
import project1.dao.ProjectRepoDB;
import project1.menu.CreateProject;

@Path("/projectservice")
public class ProjectService {
	
	IProjectRepo projectRepo = new ProjectRepoDB();

	@POST
	@Path("/addproject")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProject(CreateProject project) {
		projectRepo.addProject(project);
		return Response.status(201).build();
	}

	@GET
	@Path("/allprojects")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProjects() {
		return Response.ok((ArrayList<CreateProject>)projectRepo.viewProjects()).build();
	}

	@DELETE
	@Path("/removeproject")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeBox(CreateProject project) {
		projectRepo.removeProject(project.getName());
		return Response.status(201).build();
	}

}
