package com.zeus.TheWall.Repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.TheWall.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
	ArrayList<Message> findAll();

}
