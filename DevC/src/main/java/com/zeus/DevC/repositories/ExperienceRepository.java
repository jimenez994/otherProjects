package com.zeus.DevC.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.DevC.models.Experience;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Long> {
	ArrayList<Experience> findAll();
}
