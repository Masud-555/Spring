package com.emranhss.project.restController;

import com.emranhss.project.entity.PoliceStation;
import com.emranhss.project.service.PoliceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policestation/")
public class PoliceStationRestController {

    @Autowired
    private PoliceStationService policeStationService;

    @PostMapping("")
    public void save(@RequestBody PoliceStation ps){
        policeStationService.saveOrUpdate(ps);
    }

@GetMapping("{id}")
    public PoliceStation getById(@PathVariable Integer id){
        return policeStationService.findById(id).get();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
        policeStationService.deleteById(id);
    }

    @PutMapping("{id}")
    public void Update(@RequestBody PoliceStation ps){
        policeStationService.saveOrUpdate(ps);
    }
}
