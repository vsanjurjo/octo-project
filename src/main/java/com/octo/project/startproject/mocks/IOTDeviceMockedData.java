package com.octo.project.startproject.mocks;

import java.util.ArrayList;
import java.util.List;

import com.octo.project.startproject.entities.IOTDevice;

public class IOTDeviceMockedData {
	// list of IOT devices
	private List<IOTDevice> iotDevices;

	private static IOTDeviceMockedData instance = null;

	public static IOTDeviceMockedData getIntance() {
		if (instance == null) {
			instance = new IOTDeviceMockedData();
		}
		return instance;
	}

	public IOTDeviceMockedData() {
		iotDevices = new ArrayList<IOTDevice>();
		iotDevices.add(new IOTDevice(1, "Raspberry PI", "RASPBERRY PI 3 MODEL B ELEMENT14"));
		iotDevices.add(new IOTDevice(2, "Raspberry PI", "RASPBERRY PI 4 MODEL B"));
		iotDevices.add(new IOTDevice(3, "Arduino", "Uno SMD"));
		iotDevices.add(new IOTDevice(4, "Arduino", "Mega 2560 R3"));
		iotDevices.add(new IOTDevice(5, "BeagleBone", "Black"));
	}

	// return all IOT devices
	public List<IOTDevice> fetchIOTDevice() {
		return iotDevices;
	}

	// return device by id
	public IOTDevice getIOTDeviceById(int id) {
		for (IOTDevice iotDevice : iotDevices) {
			if (iotDevice.getId() == id) {
				return iotDevice;
			}
		}
		return null;
	}

	// search by model text
	public List<IOTDevice> searchDevices(String searchTerm) {
		List<IOTDevice> searchedDevices = new ArrayList<IOTDevice>();
		for (IOTDevice iotDevice : iotDevices) {
			if (iotDevice.getName().toLowerCase().contains(searchTerm.toLowerCase())
					|| iotDevice.getModel().toLowerCase().contains(searchTerm.toLowerCase())) {
				searchedDevices.add(iotDevice);
			}
		}
		return searchedDevices;
	}

	// create device
	public IOTDevice createIOTDevice(int id, String name, String model) {
		IOTDevice newDevice = new IOTDevice(id, name, model);
		iotDevices.add(newDevice);
		return newDevice;
	}

	// update device
	public IOTDevice updateIOTDevice(int id, String name, String model) {
		for (IOTDevice iotDevice : iotDevices) {
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
		for (IOTDevice iotDevice : iotDevices) {
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
