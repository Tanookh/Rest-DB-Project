package com.philips.fullRestDBProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.philips.fullRestDBProject.BL.UsersBL;
import com.philips.fullRestDBProject.beans.User;

@RestController
@RequestMapping("test")
public class TestController {
	
	private static String URL ="https://jsonplaceholder.typicode.com/users";
	@Autowired
	RestTemplate httpClient;
	
	
	@Autowired
	UsersBL usersBL;

	@GetMapping("getUsers")
	public ResponseEntity<String> getRemoteData()
	{
		ResponseEntity<String> res = this.httpClient.getForEntity(URL, String.class);		
		System.out.println(res);				
		return res;
	}
	
	@GetMapping("download")
	public ResponseEntity<Void> downloadUsers()
	{
		usersBL.downloadAndSaveUsers();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<User>> getAll()
	{
		List<User> users =  usersBL.getAll();		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK); 
	}

}
