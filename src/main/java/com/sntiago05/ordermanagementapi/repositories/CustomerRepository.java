package com.sntiago05.ordermanagementapi.repositories;


import com.sntiago05.ordermanagementapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
