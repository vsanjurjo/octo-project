package com.octo.project.startproject.entities;

public class IOTDevice {
	private int id;
	private String name;
	private String model;

	public IOTDevice() {
	}

	public IOTDevice(int id, String name, String model) {
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
		return "IOTDevice [id=" + id + ", name=" + name + ", model=" + model + "]";
	}
	
}
