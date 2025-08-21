package com.emranhss.restuarent.repository;

import com.emranhss.restuarent.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUserId(Long id);


    Optional<Admin> findByEmail(String email);
}