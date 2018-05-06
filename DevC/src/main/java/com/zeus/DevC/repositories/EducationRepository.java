package com.zeus.DevC.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.DevC.models.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {
	ArrayList<Education> findAll();
}
