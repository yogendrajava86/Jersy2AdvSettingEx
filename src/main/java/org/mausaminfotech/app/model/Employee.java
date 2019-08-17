package org.mausaminfotech.app.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.ws.rs.QueryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@JsonbPropertyOrder({"employee-name","employee-salary"})
@ApiModel("Employee bean")
public class Employee {
	@JsonbTransient
	@QueryParam("eid")
	private int id;
	@JsonbProperty("employee-name")
	@QueryParam("ename")
	private String name;
	@JsonbProperty("employee-salary")
	@QueryParam("esal")
	private double sal;
	public Employee() {
		super();
	}
	public Employee(int id, String name, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	@ApiModelProperty(value = "Id of employee", example = "123456")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ApiModelProperty(value = "Name of employee", example = "Test Employee", allowEmptyValue = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ApiModelProperty(value = "Salary of employee", example = "35.56" , allowEmptyValue = false)
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}
	
}
