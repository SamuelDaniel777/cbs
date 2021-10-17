package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
