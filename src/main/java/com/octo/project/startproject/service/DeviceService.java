package com.octo.project.startproject.service;

import java.util.Collection;

import com.octo.project.startproject.entities.Device;

public interface DeviceService {
	public abstract Device createDevice(Device device);

	public abstract Device updateDevice(String id, Device device);

	public abstract boolean deleteDevice(String id);

	public abstract Collection<Device> getAllDevices();
	
	public abstract Device getDeviceById(String id);

	public abstract Collection<Device> getDevicesByNameOrModel(String searchTerm);

}
