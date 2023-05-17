package com.exterro.service;

import java.util.List;

import com.exterro.entity.Car;

public interface CarService {
	Car addCar(Car car);
	List<Car> viewAllCars();
	Car viewCar(String regNo);
	Car updateCar(Car car);
	String deleteCar(String regno);
	
}
