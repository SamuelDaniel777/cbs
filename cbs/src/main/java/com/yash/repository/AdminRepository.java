package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.domain.AbstractUser;
import com.yash.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("SELECT a from Admin a WHERE a.name=:e and a.password=:p")
	AbstractUser getByNameAndPassowrd(@Param("e")String email,@Param("p") String password);
	
	
}
