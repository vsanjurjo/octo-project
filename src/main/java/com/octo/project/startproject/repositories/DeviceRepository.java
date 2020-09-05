package com.octo.project.startproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.octo.project.startproject.entities.IOTDevice;

@Repository
public interface DeviceRepository extends JpaRepository<IOTDevice, Integer> {
	
	/**
	 * 
	 * custom query to search a device by name or model
	 * 
	 * @param text
	 * @param textAgain
	 * @return
	 */
	List<IOTDevice> findByNameContainingOrModelContaining(String text, String textAgain);

}