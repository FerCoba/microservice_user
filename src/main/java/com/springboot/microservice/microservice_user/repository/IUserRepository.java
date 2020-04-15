package com.springboot.microservice.microservice_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.microservice.servicec_commons.model.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	public User findByUserName(String userName);

	void deleteById(Long userId);
//	@Query(value = "SELECT us FROM User us WHERE us.userName = ?1")
//	public User findUserByUserName(String userName);
}
