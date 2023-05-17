package com.exterro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Car {
	@Id
	private String regNo;
	private String owner;
	private String model;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String regNo, String owner, String model) {
		super();
		this.regNo = regNo;
		this.owner = owner;
		this.model = model;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", owner=" + owner + ", model=" + model + "]";
	}
}
