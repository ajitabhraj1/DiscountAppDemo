package com.ajitabh.assignment.retailsite.repository;

import org.springframework.data.repository.CrudRepository;

import com.ajitabh.assignment.retailsite.model.OrderDetails;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails,Long> {

}
