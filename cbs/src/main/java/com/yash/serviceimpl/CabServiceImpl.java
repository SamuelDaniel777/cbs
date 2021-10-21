package com.yash.serviceimpl;


import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.domain.Cab;
import com.yash.exception.CabIdException;
import com.yash.repository.CabRepository;
/**
 * class cabserviceimpl
 */
@Service
public class CabServiceImpl
{

	Logger logger= Logger.getAnonymousLogger();
	

	@Autowired
	CabRepository cabrepository;
	
	/**
	 * insert data for cab
	 * @param cab
	 * @return
	 */
	public Cab insertcab(Cab cab)
	{
		try {
		return cabrepository.save(cab);	
		}catch(Exception c)
		{
			c.printStackTrace();
		}
		return cab;
	}
	

	/**
	 * this delete 
	 * @param id
	 * @return
	 */
	public Cab deleteCabdetail(int id)
	{
		try {
		cabrepository.deleteById(id);
		}catch(Exception c)
		{
			throw new CabIdException("ID NOT FOUND");
		}
		return null;
		
	}
	

	/**
	 * types of cartype
	 * @param carType
	 * @return
	 */
	public Set<Cab> viewcabsOfTypes(String carType) {
		try {
			Set<Cab> cablistCabs= cabrepository.viewcabsOfTypes(carType);
			return cablistCabs;	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Types of cartype Size
	 * @param carType
	 * @return
	 */
	public int countCabsOfType(String carType)
	{
		return cabrepository.viewcabsOfTypes(carType).size();
		
	}



}
