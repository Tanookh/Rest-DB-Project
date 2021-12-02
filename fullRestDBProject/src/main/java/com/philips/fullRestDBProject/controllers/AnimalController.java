package com.philips.fullRestDBProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philips.fullRestDBProject.BL.AnimalsBL;
import com.philips.fullRestDBProject.beans.Animal;

@RestController
@RequestMapping("animals")
public class AnimalController {
	
	@Autowired
	AnimalsBL animalsBL;
	
	@PostMapping("add")
	public ResponseEntity<Void> addAnimal(String name, String color, Integer year, String country) 
	{
		Animal animal = new Animal();
		animal.setName(name);
		animal.setColor(color);
		animal.setYearOfBirth(year);
		animal.setCountryOfOrigin(country);
		
		try {
			animalsBL.addAnimal(animal);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			
		}		
	}
	
	@GetMapping("get")
	public ResponseEntity<List<Animal>> getAll()
	{
		return new ResponseEntity<List<Animal>>(animalsBL.getAllAnimals(), HttpStatus.OK);		
	}

}
