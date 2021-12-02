package com.philips.fullRestDBProject.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.philips.fullRestDBProject.beans.User;
import com.philips.fullRestDBProject.repositories.UsersRepo;

@Service
public class UsersBL {
	private static String URL ="https://jsonplaceholder.typicode.com/users";
	
	
	@Autowired
	UsersRepo repo;
	
	@Autowired
	RestTemplate httpClient;
	
	
	public void downloadAndSaveUsers()
	{
		System.out.println("Downloading users");
		ResponseEntity<User[]> usersResponse = this.httpClient.getForEntity(URL, User[].class);
		
		User[] users = usersResponse.getBody();
		
		System.out.println("Download completed, Now saving to DB");
		for(User user : users)
		{
			repo.save(user);
		}
		System.out.println("Download and save completed");
	}


	public List<User> getAll() {		
		return repo.findAll();
	}
}
