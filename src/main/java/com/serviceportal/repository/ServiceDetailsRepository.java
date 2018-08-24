package com.serviceportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceportal.model.ServiceDetails;

public interface ServiceDetailsRepository extends JpaRepository<ServiceDetails, Long> {

}
