package com.octo.project.startproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author vsanj
 *
 */
@RestController
public class IOTController {

	/**
	 * 
	 * @return String
	 * 
	 * TODO: implement the use of ResponseEntity 
	 */
	@RequestMapping
	public String index() {
		return "Congratulations from IOTController.java";
	}
	
}
