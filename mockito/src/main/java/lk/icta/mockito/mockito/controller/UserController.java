package lk.icta.mockito.mockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.icta.mockito.mockito.entity.Response;
import lk.icta.mockito.mockito.entity.User;
import lk.icta.mockito.mockito.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	//get the service class
	private UserService service;
	
	//save the new object to the database
	@PostMapping("/userRegistration")
	public Response save(@RequestBody User user) {
		
		return service.saveUser(user);
	}
	
	//get all the users from database
	
	@GetMapping("/userDetails")
	public Response getAllUsers() {
		System.out.println("----user details fetching---");
		return service.getAllUsers();
	}

}
