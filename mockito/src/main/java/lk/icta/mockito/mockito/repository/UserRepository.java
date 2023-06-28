package lk.icta.mockito.mockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.icta.mockito.mockito.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	

}
