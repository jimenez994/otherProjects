package com.zeus.DevC.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.DevC.models.Portfolio;

@Repository
public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {
	ArrayList<Portfolio> findAll();
	Portfolio findByHandle(String handle);
	Portfolio findByUserId(long id);
}
