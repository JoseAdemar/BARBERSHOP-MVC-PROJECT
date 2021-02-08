package com.barbershop.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.barbershop.com.model.UserModel;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserModel, Long> {
 
	@Query("select u from UserModel u where u.email = ?1")
	UserModel findUserByLogin(String username);
}
