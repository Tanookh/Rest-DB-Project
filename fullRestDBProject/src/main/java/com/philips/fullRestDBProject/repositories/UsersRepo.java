package com.philips.fullRestDBProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philips.fullRestDBProject.beans.User;

public interface UsersRepo extends JpaRepository<User, Integer>{

}
