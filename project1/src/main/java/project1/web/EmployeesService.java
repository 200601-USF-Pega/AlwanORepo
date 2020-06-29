package project1.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import project1.dao.EmployeeRepo;
import project1.dao.EmployeeRepoDB;
import project1.menu.CreateProject;
import project1.menu.Employee;

@Path("/employeesservice")
public class EmployeesService {
	
	EmployeeRepo employeeRepo = new EmployeeRepoDB();

	@POST
	@Path("/addemployee")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee employee) {
		employeeRepo.addEmployee(employee);
		return Response.status(201).build();
	}

	@GET
	@Path("/allemployees")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployees() {
		return Response.ok((ArrayList<Employee>)employeeRepo.getAllEmployees()).build();
	}

	@DELETE
	@Path("/removeemployee")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeEmployee(Employee employee) {
		employeeRepo.deleteEmployee(employee.getName());
		return Response.status(201).build();
	}

}