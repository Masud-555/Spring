package com.emranhss.restuarent.repository;

import com.emranhss.restuarent.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTabRepo extends JpaRepository<Employee, Long> {
}
