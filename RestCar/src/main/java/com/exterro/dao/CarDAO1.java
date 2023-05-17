package com.exterro.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.exterro.entity.Car;

public class CarDAO1 {
	@SuppressWarnings("unused")
	private static ArrayList<Car> carList = new ArrayList<Car>();
	private Session sess = SessionFactoryProvider.getSessionFactory().openSession();

	public Car addCar(Car car) {
		sess.beginTransaction();
		sess.save(car);
		sess.getTransaction().commit();
		sess.close();
		return car;
	}

	@SuppressWarnings("unchecked")
	public List<Car> getAllCars() {
		String hql = "FROM com.exterro.entity.Car";
		Query query = sess.createQuery(hql);
		@SuppressWarnings("rawtypes")
		List carList = query.list();
		return carList;
	}

	public Car getCar(String regNo) {
		// Read a record from Table
		sess.beginTransaction();
		Car car = (Car) sess.get(Car.class, regNo);
		System.out.println(car);
		sess.getTransaction().commit();
		sess.close();
		if (car != null)
			return car;
		
		return new Car();
	}

	public Car updateCar(Car newCar) {
		sess.beginTransaction();
		sess.saveOrUpdate(newCar);
		sess.getTransaction().commit();
		sess.close();
		return newCar;
	}

	public String deleteCar(String regNo) {
		String result = "";
		sess.beginTransaction();
		Car car = (Car) sess.get(Car.class, regNo);
		if (car != null) {
			result = "Deleted Successfully";
			sess.delete(car);
		}
		else {
			result = "Car Unavailable";
		}
		sess.getTransaction().commit();
		sess.close();
		
		return result;
	}
}
