package com.serviceportal;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.serviceportal.model.ServiceDetails;
import com.serviceportal.repository.ServiceDetailsRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ServiceDetailsRepositoryIntegrationTest {

	@Autowired
	private ServiceDetailsRepository ServiceDetailsRepository;

	@Test
	public void testFindAll() {
		List<ServiceDetails> wrecks = ServiceDetailsRepository.findAll();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}
	
}
