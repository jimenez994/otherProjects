package com.zeus.TheWall.Repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.TheWall.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	ArrayList<User> findAll();
	User findByUsername(String username);
}
