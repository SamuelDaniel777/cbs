package com.yash.web;

import java.util.HashMap;

/*
 * customer controller
 * author akshay.patil
 */

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.domain.Customer;
import com.yash.exception.CustomerIdNotFoundException;
import com.yash.exception.InvalidData;
import com.yash.exception.InvalidNameException;
import com.yash.exception.RecordNotFoundException;

import com.yash.serviceimpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController 
{
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping("/login")
	public Customer customerLogin(Customer customer,HttpSession session) throws InvalidData {
		logger.trace("customer data recived"+customer.getEmail()+customer.getPassword());
		Customer fromCustServ=customerServiceImpl.requestLogin(customer.getEmail(),customer.getPassword());
		logger.trace("recevied the valid or null data"+fromCustServ);
		if (fromCustServ!=null) {
			session.setAttribute("customerSession", fromCustServ);
			return fromCustServ;
		} else {
			return new Customer();
		}
		
	}
	/*
	 * insert customer
	 */
	
	@PostMapping("/register")//http://localhost:8080/cbs/register
	public ResponseEntity<?> createcustomer(@Valid Customer customer,BindingResult result)
	{
		Map<String, String> errorMap=new HashMap<>();
		
		for (FieldError fieldError : result.getFieldErrors()) {
			errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		if (result.hasErrors()) {
			return new ResponseEntity <Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		Customer cus= customerServiceImpl.insertCustomer(customer);
		return new ResponseEntity<Customer>(cus,HttpStatus.CREATED);
	}
	
	/*
	 * update customer by id
	 */
	@PutMapping("/update")//http://localhost:8080/cbs/update
	public Customer updatecustomer(Customer customer)
	{
		Customer cus= customerServiceImpl.insertCustomer(customer);
		return cus;
	}
	/*
	 * list of all customer
	 */
	@GetMapping("/list")//http://localhost:8080/cbs/list
	public List<Customer> getAllCustomer()
	{
		return (List<Customer>) customerServiceImpl.listCustomer();
	}
	/*
	 * delete customer by id
	 */
	@DeleteMapping("/delete/{id}")//http://localhost:8080/cbs/delete/{id}
	public ResponseEntity<HttpStatus> deletecustomer(@PathVariable("id") int id) throws CustomerIdNotFoundException
	{
		customerServiceImpl.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
	/*
	 * get customer by id
	 */
	@GetMapping("/findbyid/{id}")//http://localhost:8080/cbs/findbyid/
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int custid) throws CustomerIdNotFoundException
	{
		Customer entity = customerServiceImpl.getCustomerById(custid);
		return new ResponseEntity<Customer>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	/*
	 * get customer by name
	 */
	@GetMapping("/findbyname/{name}")//http://localhost:8080/cbs/findbyname/
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String CustName) throws InvalidNameException, Throwable
	{
		Customer entity = customerServiceImpl.getCustomerByName(CustName);
		return new ResponseEntity<Customer>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	/*
	 * get customer by email
	 */
	@GetMapping("/findbyemail/{email}")//http://localhost:8080/cbs/findbyemail/
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String custemail) throws RecordNotFoundException 
	{
		Customer entity = customerServiceImpl.getCustomerByEmail(custemail);
		return new ResponseEntity<Customer>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	
}
