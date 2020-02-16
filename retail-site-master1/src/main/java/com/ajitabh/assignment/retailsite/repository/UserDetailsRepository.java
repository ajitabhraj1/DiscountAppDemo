package com.ajitabh.assignment.retailsite.repository;

import org.springframework.data.repository.CrudRepository;

import com.ajitabh.assignment.retailsite.model.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails,Long> {

}
