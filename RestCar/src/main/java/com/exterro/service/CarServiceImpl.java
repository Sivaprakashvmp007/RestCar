package com.exterro.service;

import java.util.List;

import com.exterro.dao.CarDAO1;
import com.exterro.entity.Car;

public class CarServiceImpl implements  CarService{
	private CarDAO1 carDao = new CarDAO1();

	public Car addCar(Car car) {
		return carDao.addCar(car);
	}

	public List<Car> viewAllCars() {
		return carDao.getAllCars();
	}

	public Car viewCar(String regNo) {
		return carDao.getCar(regNo);
	}

	public Car updateCar(Car car) {
		return carDao.updateCar(car);
	}

	public String deleteCar(String regno) {
		return carDao.deleteCar(regno);
	}
	
	
}
