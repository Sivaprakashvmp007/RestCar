package com.exterro.dao;

import java.util.ArrayList;
import java.util.List;

import com.exterro.entity.Car;

public class CarDAO {
	private static ArrayList<Car> carList = new ArrayList<Car>();
	
	public Car addCar(Car car) {
		carList.add(car);
		return car;
	}
	
	public List<Car> getAllCars(){
		return carList;
	}
	
	public Car getCar(String regNo) {
		for(Car car:carList) {
			if(car.getRegNo().toLowerCase().equals(regNo.toLowerCase())) {
				return car;
			}
		}
		return new Car();
	}
	
	public Car updateCar(Car newCar) {
		for(int i=0; i<carList.size(); i++) {
			if(carList.get(i).getRegNo().toLowerCase().equals(newCar.getRegNo().toLowerCase())) {
				carList.remove(carList.get(i));
			}
		}
		carList.add(newCar);
		return newCar;
	}
	
	public String deleteCar(String regNo) {
		for(Car car:carList) {
			if(car.getRegNo().toLowerCase().equals(regNo.toLowerCase())) {
				carList.remove(car);
				return "Car Removed Successfully";
			}
		}
		return "Car Unavailable";
	}
}
