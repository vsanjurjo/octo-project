package com.octo.project.startproject.controllers;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.octo.project.startproject.entities.Device;
import com.octo.project.startproject.service.DeviceService;

/**
 * 
 * @author vsanj
 *
 */
@RestController
public class DeviceController {

	@Autowired
	DeviceService deviceService;

	/**
	 * 
	 * Returns a List of all the device on database
	 * 
	 * @return Collection<Device>
	 */
	@GetMapping("/device")
	public Collection<Device> index() {
		return deviceService.getAllDevices();
	}

	/**
	 * 
	 * Returns a device from database by its id
	 * 
	 * @param id
	 * @return Device
	 */
	@GetMapping("/device/{id}")
	public Device show(@PathVariable String id) {
		return deviceService.getDeviceById(id);
	}

	/**
	 * 
	 * Search devices by a search term
	 * 
	 * @param body
	 * @return Collection<Device>
	 */
	@PostMapping("device/search")
	public Collection<Device> search(@RequestBody Map<String, String> body) {
		String searchTerm = body.get("text");
		return deviceService.getDevicesByNameOrModel(searchTerm);
	}

	/**
	 * 
	 * Creates a device in the database
	 * 
	 * @param body
	 * @return Device
	 */
	@PostMapping("device")
	public Device create(@RequestBody Map<String, String> body) {
		return deviceService.createDevice(new Device(body.get("name"), body.get("model")));
	}

	/**
	 * 
	 * Update a device by its id
	 * 
	 * @param id
	 * @param body
	 * @return Device
	 */
	@PutMapping("device/{id}")
	public Device update(@PathVariable String id, @RequestBody Map<String, String> body) {
		return deviceService.updateDevice(id, new Device(body.get("name"), body.get("model")));
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
		return deviceService.deleteDevice(id);
	}

}
