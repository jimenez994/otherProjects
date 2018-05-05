package com.zeus.DevC.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.DevC.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	ArrayList<User> findAll();
	User findByEmail(String email);
}
