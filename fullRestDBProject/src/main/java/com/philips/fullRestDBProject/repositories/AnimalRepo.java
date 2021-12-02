package com.philips.fullRestDBProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philips.fullRestDBProject.beans.Animal;

public interface AnimalRepo extends JpaRepository<Animal, Integer>{
	public List<Animal> findByName(String name);
}
