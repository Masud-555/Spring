package com.emranhss.restuarent.repository;

import com.emranhss.restuarent.entity.Employee;
import com.emranhss.restuarent.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Long> {



}
