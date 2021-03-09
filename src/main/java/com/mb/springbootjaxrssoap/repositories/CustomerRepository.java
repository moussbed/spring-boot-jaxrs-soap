package com.mb.springbootjaxrssoap.repositories;

import com.mb.springbootjaxrssoap.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
