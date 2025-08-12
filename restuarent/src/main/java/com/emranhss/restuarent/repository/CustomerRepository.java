package com.emranhss.restuarent.repository;

import com.emranhss.restuarent.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUserId(int userId);

    @Query("SELECT js FROM Customer js WHERE js.user.email = :email")
    Optional<Customer> findByUserEmail(@Param("email") String email);


}
