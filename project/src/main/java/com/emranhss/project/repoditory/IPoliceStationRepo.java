package com.emranhss.project.repoditory;

import com.emranhss.project.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPoliceStationRepo extends JpaRepository<PoliceStation, Integer> {

       List<PoliceStation> findByDistrictId();

}
