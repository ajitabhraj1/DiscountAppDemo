package com.ajitabh.assignment.retailsite.repository;

import org.springframework.data.repository.CrudRepository;

import com.ajitabh.assignment.retailsite.model.AffiliateDetails;
import com.ajitabh.assignment.retailsite.model.UserDiscount;

public interface UserDiscountRepository extends CrudRepository<UserDiscount,Long> {

}
