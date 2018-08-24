package com.serviceportal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.serviceportal.model.ServiceDetails;

public class ServiceDetailsStub {
	private static Map<Long, ServiceDetails> ServiceDetailsList = new HashMap<Long, ServiceDetails>();
	private static Long idIndex = 3L;

	//populate initial services
	
	static {
		ServiceDetails a = new ServiceDetails(1L, "Service1", "Service1", "TRUE");
		ServiceDetailsList.put(1L, a);
		ServiceDetails b = new ServiceDetails(2L, "Service2", "Service2", "FALSE");
		ServiceDetailsList.put(2L, b);
		ServiceDetails c = new ServiceDetails(3L, "Service3", "Service3", "TRUE");
		ServiceDetailsList.put(3L, c);
	}

	public static List<ServiceDetails> list() {
		return new ArrayList<ServiceDetails>(ServiceDetailsList.values());
	}

	public static ServiceDetails create(ServiceDetails serviceDetails) {
		idIndex += idIndex;
		
		serviceDetails.setId(idIndex);
		ServiceDetailsList.put(idIndex, serviceDetails);
		return serviceDetails;
	}

	public static ServiceDetails get(Long id) {
		return ServiceDetailsList.get(id);
	}

	public static ServiceDetails update(Long id, ServiceDetails serviceDetails) {
		ServiceDetailsList.put(id, serviceDetails);
		return serviceDetails;
	}
	
	
	

	public static ServiceDetails delete(Long id) {
		return ServiceDetailsList.remove(id);
	}
}
