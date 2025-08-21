package com.emranhss.restuarent.repository;

import com.emranhss.restuarent.entity.BookTable;
import com.emranhss.restuarent.entity.Customer;
import com.emranhss.restuarent.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTabRepo extends JpaRepository<Employee, Long> {

    List<BookTable> findByCustomer(Customer customer);
    List<BookTable> findByEmail(String email);
}
