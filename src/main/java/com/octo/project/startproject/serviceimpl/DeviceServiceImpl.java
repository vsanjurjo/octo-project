package com.octo.project.startproject.serviceimpl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octo.project.startproject.entities.Device;
import com.octo.project.startproject.repositories.DeviceRepository;
import com.octo.project.startproject.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceRepository deviceRepository;

	/**
	 * Create a device in database
	 */
	@Override
	public Device createDevice(Device device) {
		return deviceRepository.save(device);
	}

	/**
	 * Update a device in database
	 */
	@Override
	public Device updateDevice(String id, Device newDevice) {
		int deviceId = Integer.parseInt(id);

		Optional<Device> optionalDevice = deviceRepository.findById(deviceId);

		// TODO add optional validation
		Device device = optionalDevice.get();
		device.setName(newDevice.getName());
		device.setModel(newDevice.getModel());

		return deviceRepository.save(device);

	}

	/**
	 * Deletes a device in database
	 */
	@Override
	public boolean deleteDevice(String id) {
		int deviceId = Integer.parseInt(id);
		deviceRepository.deleteById(deviceId);
		return true;
	}

	/**
	 * Retrieves all devices from database
	 */
	@Override
	public Collection<Device> getAllDevices() {
		return deviceRepository.findAll();
	}

	/**
	 * Retrieves a device from database by its id
	 */
	@Override
	public Device getDeviceById(String id) {
		// TOOD add optional validation
		int deviceId = Integer.parseInt(id);
		return deviceRepository.findById(deviceId).get();
	}

	/**
	 * Retrieves one or more devices from database by a searchTerm
	 */
	@Override
	public Collection<Device> getDevicesByNameOrModel(String searchTerm) {
		return deviceRepository.findByNameContainingOrModelContaining(searchTerm, searchTerm);
	}

}
