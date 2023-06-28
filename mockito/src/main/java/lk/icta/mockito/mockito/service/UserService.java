package lk.icta.mockito.mockito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.icta.mockito.mockito.entity.Response;
import lk.icta.mockito.mockito.entity.User;
import lk.icta.mockito.mockito.repository.UserRepository;

@Service
public class UserService {
	
//	get the user repository here
	@Autowired
	private UserRepository repository;
	
//	save a new object to the database
	public Response saveUser(User user) {
		
		repository.save(user);
		return new Response("saved user with id" + user.getId(), Boolean.TRUE);
		
	}
	
//	get all the user objects from the database
	public Response getAllUsers() {
		
		List<User> users = repository.findAll();
		return new Response("number of User:"+ users.size(), Boolean.TRUE);
	}

}

