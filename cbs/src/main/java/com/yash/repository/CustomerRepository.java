package com.yash.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> 
{
	List<Customer> findById(int id);
}