package com.serviceportal;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.serviceportal.controller.ServiceDetailsController;
import com.serviceportal.model.ServiceDetails;
import com.serviceportal.repository.ServiceDetailsRepository;

public class ServiceDetailsControllerTest {
	@InjectMocks
	private ServiceDetailsController sc;

	@Mock
	private ServiceDetailsRepository ServiceDetailsRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testServiceDetailsGet() {
    	ServiceDetails sw = new ServiceDetails();
    	sw.setId(1l);
		when(ServiceDetailsRepository.findOne(1l)).thenReturn(sw);

		ServiceDetails wreck = sc.get(1L);

		verify(ServiceDetailsRepository).findOne(1l);		

//		assertEquals(1l, wreck.getId().longValue());	
		assertThat(wreck.getId(), is(1l));
	}

}
