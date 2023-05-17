package com.exterro.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.exterro.entity.Car;
import com.exterro.service.CarService;
import com.exterro.service.CarServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/cars")
public class CarController {
	private CarService carSvc = new CarServiceImpl();
	 

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewCar(@FormParam("regNo") String regNo, @FormParam("owner") String owner,
			@FormParam("model") String model) {

		Car car = null;
		Car car1 = null;
		//create car object from request payload
		car = new Car(regNo, owner, model);
		System.out.println(car);
		car1 = carSvc.addCar(car);

		return Response.status(200).entity(car1).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCars() {
		ObjectMapper carMapper = new ObjectMapper();
		List<Car> carList = carSvc.viewAllCars();
		String jsonCarList = "";
		try {
			jsonCarList = carMapper.writeValueAsString(carList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(jsonCarList).build();
	}

	@Path("{regNo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCar(@PathParam("regNo") String regNo) {
		Car car = carSvc.viewCar(regNo);
	
		return Response.status(200).entity(car).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public Response updateCar(@FormParam("regNo") String regNo, @FormParam("owner") String owner,
			@FormParam("model") String model) {

		Car car = null;		
		car = new Car(regNo, owner, model);
		System.out.println(car);
		Car c1 = carSvc.updateCar(car);
		System.out.println(c1);
		return Response.status(200).entity(c1).build();
	}

	@Path("/{regNo}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteCar(@PathParam("regNo") String regNo) {

		String result = "";
		try {
			result = carSvc.deleteCar(regNo);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(result).build();
	}

}
