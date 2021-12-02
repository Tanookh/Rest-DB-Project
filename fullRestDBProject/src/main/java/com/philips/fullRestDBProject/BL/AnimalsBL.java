package com.philips.fullRestDBProject.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.fullRestDBProject.beans.Animal;
import com.philips.fullRestDBProject.repositories.AnimalRepo;

@Service
public class AnimalsBL {
	
	@Autowired
	AnimalRepo repo;
	
	//Adds new animal to the db, if not exist (same name)
	public void addAnimal(Animal animal) throws Exception
	{
		//check if exists 
		List<Animal> animals = repo.findByName(animal.getName());
		if(animals.isEmpty())
		{
			//if no, add to the DB
			repo.save(animal);
		}
		else
		{
			//else do nothing/Throw exception ... 
			throw new Exception(animal.getName()+" already exsists");
		}				
	}
	
	public List<Animal> getAllAnimals()
	{
		return repo.findAll();
	}

}
