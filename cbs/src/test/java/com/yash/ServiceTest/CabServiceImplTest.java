package com.yash.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.CbsApplication;
import com.yash.domain.Cab;
import com.yash.domain.Driver;
import com.yash.repository.CabRepository;
import com.yash.serviceimpl.CabServiceImpl;


@SpringBootTest(classes= {CbsApplication.class})
@RunWith(MockitoJUnitRunner.class)
public class CabServiceImplTest {
	
	//@InjectMocks
	@Autowired
	CabServiceImpl cabServiceImpl;

	@MockBean
	CabRepository cabRepository;
	
	/**
	 * Test case for InsertDataInCab
	 */
	@Test
	public void CabInsertDataTest()
	{

		Cab cab = new Cab(9,new Driver(),"newmini",(float) 12.00);
		
		when(cabRepository.save(cab)).thenReturn(cab);
		
		assertThat(cabServiceImpl.insertcab(cab)).isEqualTo(cab);
	}
	
	@Test
	public void CabDeleteDataTest()
	{
		Cab cab = new Cab(10,new Driver(),"mini",(float) 17.00);
		
		when(cabRepository.deleteById(cab.getCabid())).thenReturn(cab);
		
		verify(cabServiceImpl.deleteCabdetail(cab.getCabid()));
	}
	


}
