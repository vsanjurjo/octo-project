package com.octo.project.startproject.mocks;

import java.util.ArrayList;
import java.util.List;

import com.octo.project.startproject.entities.Device;

public class DeviceMockedData {
	// list of IOT devices
	private List<Device> iotDevices;

	private static DeviceMockedData instance = null;

	public static DeviceMockedData getIntance() {
		if (instance == null) {
			instance = new DeviceMockedData();
		}
		return instance;
	}

	public DeviceMockedData() {
		iotDevices = new ArrayList<Device>();
		iotDevices.add(new Device(1, "Raspberry PI", "RASPBERRY PI 3 MODEL B ELEMENT14"));
		iotDevices.add(new Device(2, "Raspberry PI", "RASPBERRY PI 4 MODEL B"));
		iotDevices.add(new Device(3, "Arduino", "Uno SMD"));
		iotDevices.add(new Device(4, "Arduino", "Mega 2560 R3"));
		iotDevices.add(new Device(5, "BeagleBone", "Black"));
	}

	// return all IOT devices
	public List<Device> fetchIOTDevice() {
		return iotDevices;
	}

	// return device by id
	public Device getIOTDeviceById(int id) {
		for (Device iotDevice : iotDevices) {
			if (iotDevice.getId() == id) {
				return iotDevice;
			}
		}
		return null;
	}

	// search by model text
	public List<Device> searchDevices(String searchTerm) {
		List<Device> searchedDevices = new ArrayList<Device>();
		for (Device iotDevice : iotDevices) {
			if (iotDevice.getName().toLowerCase().contains(searchTerm.toLowerCase())
					|| iotDevice.getModel().toLowerCase().contains(searchTerm.toLowerCase())) {
				searchedDevices.add(iotDevice);
			}
		}
		return searchedDevices;
	}

	// create device
	public Device createIOTDevice(int id, String name, String model) {
		Device newDevice = new Device(id, name, model);
		iotDevices.add(newDevice);
		return newDevice;
	}

	// update device
	public Device updateIOTDevice(int id, String name, String model) {
		for (Device iotDevice : iotDevices) {
			if (iotDevice.getId() == id) {
				int deviceIndex = iotDevices.indexOf(iotDevice);
				iotDevice.setName(name);
				iotDevice.setModel(model);
				iotDevices.set(deviceIndex, iotDevice);
				return iotDevice;
			}
		}
		return null;
	}

	// delete device by id
	public boolean delete(int id) {
		int deviceIndex = -1;
		for (Device iotDevice : iotDevices) {
			if (iotDevice.getId() == id) {
				deviceIndex = iotDevices.indexOf(iotDevice);
				continue;
			}
		}
		if (deviceIndex > -1) {
			iotDevices.remove(deviceIndex);
		}
		return true;
	}

}
