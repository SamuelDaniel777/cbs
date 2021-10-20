package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.domain.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	
}
