package com.octo.project.startproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String model;

	public Device() {
	}
	
	public Device(String name, String model) {
		this.setName(name);
		this.setModel(model);
	}

	public Device(int id, String name, String model) {
		this.setId(id);
		this.setName(name);
		this.setModel(model);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", model=" + model + "]";
	}
	
}
