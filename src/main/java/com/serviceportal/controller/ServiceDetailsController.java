package com.serviceportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.serviceportal.model.ServiceDetails;
import com.serviceportal.repository.ServiceDetailsRepository;

@RestController
@RequestMapping("api/v1/")
public class ServiceDetailsController {

	@Autowired
	private ServiceDetailsRepository ServiceDetailsRepository;

	@RequestMapping(value = "ServiceDetails", method = RequestMethod.GET)
	public List<ServiceDetails> list() {
		//List<ServiceDetails> stringList = new ArrayList<ServiceDetails>();
		
		List<ServiceDetails> ServiceDetailsList=ServiceDetailsRepository.findAll();
		
		for( ServiceDetails s: ServiceDetailsList ){

			System.out.println(s);

			}
		
		return ServiceDetailsList;
		
		//return ServiceDetailsRepository.findAll();
	}

	@RequestMapping(value = "AddServiceDetails", method = RequestMethod.POST)
	public ServiceDetails create(@RequestBody ServiceDetails ServiceDetails) {
		return ServiceDetailsRepository.saveAndFlush(ServiceDetails);
	}

	@RequestMapping(value = "ServiceDetails/{id}", method = RequestMethod.GET)
	public ServiceDetails get(@PathVariable Long id) {
		return ServiceDetailsRepository.findOne(id);
	}

	@RequestMapping(value = "ServiceDetails/{id}", method = RequestMethod.PUT)
	public ServiceDetails update(@PathVariable Long id, @RequestBody ServiceDetails ServiceDetails) {
		ServiceDetails existingServiceDetails = ServiceDetailsRepository.findOne(id);
		BeanUtils.copyProperties(ServiceDetails, existingServiceDetails);
		return ServiceDetailsRepository.saveAndFlush(existingServiceDetails);
	}

	@RequestMapping(value = "ServiceDetails/{id}", method = RequestMethod.DELETE)
	public ServiceDetails delete(@PathVariable Long id) {
		ServiceDetails existingServiceDetails = ServiceDetailsRepository.findOne(id);
		ServiceDetailsRepository.delete(existingServiceDetails);
		return existingServiceDetails;
	}

}
