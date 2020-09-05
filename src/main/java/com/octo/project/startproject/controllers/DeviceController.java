package com.octo.project.startproject.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.octo.project.startproject.entities.Device;
import com.octo.project.startproject.repositories.DeviceRepository;

/**
 * 
 * @author vsanj
 *
 */
@RestController
public class DeviceController {
	
	@Autowired
	DeviceRepository deviceRepository;

	/**
	 * 
	 * Returns a List of all the device on database
	 * 
	 * @return List<Device>
	 */
	@GetMapping("/device")
	public List<Device> index() {
		return deviceRepository.findAll();
	}

	/**
	 * 
	 * Returns a device from database by its id
	 * 
	 * @param id
	 * @return Optional<Device>
	 */
	@GetMapping("/device/{id}")
	public Optional<Device> show(@PathVariable String id) {
		int deviceId = Integer.parseInt(id);
		return deviceRepository.findById(deviceId);
	}
	
	/**
	 * 
	 * Search devices by a search term
	 * 
	 * @param body
	 * @return List<Device>
	 */
	@PostMapping("device/search")
	public List<Device> search(@RequestBody Map<String, String> body){
		String searchTerm = body.get("text");
		return deviceRepository.findByNameContainingOrModelContaining(searchTerm, searchTerm);
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
		String name = body.get("name");
		String model = body.get("model");
		return deviceRepository.save(new Device(name,model));
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
		int deviceId = Integer.parseInt(id);
		
		Optional<Device> optionalDevice = deviceRepository.findById(deviceId);
		
		Device device = optionalDevice.get();
		device.setName(body.get("name"));
		device.setModel(body.get("model"));
		
		return deviceRepository.save(device);
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
		deviceRepository.deleteById(deviceId);
		return true;
	}

}
