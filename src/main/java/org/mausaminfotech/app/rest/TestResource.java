package org.mausaminfotech.app.rest;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mausaminfotech.app.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/test")
@Api(tags = {"Employee"})
public class TestResource {

	@GET
	@Path("/show")
	@Produces(MediaType.TEXT_PLAIN)
	public String showMsg() {
		return "Welcome";
	}
	
	@GET
	@Path("/getempj")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(produces="application/json", value = "Fetch employee details", httpMethod="GET", notes = "<br>This service fetches Employee details", response = Employee.class)
	//@ApiResponses(value = { @ApiResponse(code = 200,response = Employee.class, message = "Successful operation"),@ApiResponse(code = 400, message = "Bad Request", response = Error.class), @ApiResponse(code = 422, message = "Invalid data", response = Error.class), @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public Employee empDataJson(@BeanParam Employee emp) {
		return emp;
	}
	@GET
	@Path("/getemp")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(produces="text/plain", value = "Fetch employee details", httpMethod="GET", notes = "<br>This service fetches Employee details", response = Employee.class)
	public String empData(@BeanParam Employee emp) {
		return "Emp Data :"+emp;
	}
}
