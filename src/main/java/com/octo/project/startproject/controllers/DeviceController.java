package com.octo.project.startproject.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.octo.project.startproject.entities.IOTDevice;
import com.octo.project.startproject.mocks.IOTDeviceMockedData;

/**
 * 
 * @author vsanj
 *
 */
@RestController
public class DeviceController {

	IOTDeviceMockedData iotDeviceMockedData = IOTDeviceMockedData.getIntance();

	/**
	 * 
	 * Returns a List of all the device on database
	 * 
	 * @return List<IOTDevice>
	 */
	@GetMapping("/device")
	public List<IOTDevice> index() {
		return iotDeviceMockedData.fetchIOTDevice();
	}

	/**
	 * 
	 * Returns a device from database by its id
	 * 
	 * @param id
	 * @return IOTDevice
	 */
	@GetMapping("/device/{id}")
	public IOTDevice show(@PathVariable String id) {
		int deviceId = Integer.parseInt(id);
		return iotDeviceMockedData.getIOTDeviceById(deviceId);
	}
	
	/**
	 * 
	 * Search devices by a search term
	 * 
	 * @param body
	 * @return List<IOTDevice>
	 */
	@PostMapping("device/search")
	public List<IOTDevice> search(@RequestBody Map<String, String> body){
		String searchTerm = body.get("text");
		return iotDeviceMockedData.searchDevices(searchTerm);
	}

	/**
	 * 
	 * Creates a device in the database
	 * 
	 * @param body
	 * @return IOTDevice
	 */
	@PostMapping("device")
	public IOTDevice create(@RequestBody Map<String, String> body) {
		int id = Integer.parseInt(body.get("id"));
		String name = body.get("name");
		String model = body.get("model");
		return iotDeviceMockedData.createIOTDevice(id, name, model);
	}
	
	/**
	 * 
	 * Update a device by its id
	 * 
	 * @param id
	 * @param body
	 * @return IOTDevice
	 */
	@PutMapping("device/{id}")
	public IOTDevice update(@PathVariable String id, @RequestBody Map<String, String> body) {
		int deviceId = Integer.parseInt(id);
		String name = body.get("name");
		String model = body.get("model");
		return iotDeviceMockedData.updateIOTDevice(deviceId, name, model);
	}
	
	/**
	 * 
	 * Deletes a device by its id
	 * 
	 * @param id
	 * @return boolean
	 */
	@DeleteMapping("device/{id}")
	public boolean delete(@PathVariable String id) {
		int deviceId = Integer.parseInt(id);
		return iotDeviceMockedData.delete(deviceId);
	}

}
