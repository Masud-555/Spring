package com.emranhss.restuarent.repository;

import com.emranhss.restuarent.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByEmployeeId(int userId);

}
