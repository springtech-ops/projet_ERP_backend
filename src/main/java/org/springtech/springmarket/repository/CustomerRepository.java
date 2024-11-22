package org.springtech.springmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springtech.springmarket.domain.Customer;

public interface CustomerRepository extends PagingAndSortingRepository <Customer, Long>, ListCrudRepository<Customer, Long> {
    Page<Customer> findByNameContaining(String name, Pageable pageable);
}
