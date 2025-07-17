package com.emranhss.project.restController;

import com.emranhss.project.dto.DistrictResponseDTO;
import com.emranhss.project.entity.District;
import com.emranhss.project.service.DistrictService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/district")
public class DistrictRestController {

    @Autowired
    private DistrictService districtService;

@PostMapping
    public ResponseEntity<String> saveDistrict(@RequestBody District district){
        try{
            districtService.save(district);
            return ResponseEntity.ok("Data Saved");
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    public ResponseEntity<List<DistrictResponseDTO>> getDistricts(){
    try{
        List<DistrictResponseDTO> dList = districtService.getAllDistrictDTOs();
        return ResponseEntity.ok(dList);
    }
    catch (EntityNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    }
}
