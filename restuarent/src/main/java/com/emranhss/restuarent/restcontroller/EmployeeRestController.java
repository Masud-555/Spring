package com.emranhss.restuarent.restcontroller;

import com.emranhss.restuarent.entity.Employee;
import com.emranhss.restuarent.repository.IEmployeeRepository;
import com.emranhss.restuarent.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private IEmployeeRepository employeeRepository;

    // ✅ সব employee দেখাবে
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    // ✅ নির্দিষ্ট employee (id দিয়ে)
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ নতুন employee create
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    // ✅ employee update
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.getById(id)
                .map(existing -> {
                    // field update
                    existing.setPhoto(updatedEmployee.getPhoto());
                    existing.setName(updatedEmployee.getName());
                    existing.setSalary(updatedEmployee.getSalary());
                    existing.setEmail(updatedEmployee.getEmail());
                    existing.setPhone(updatedEmployee.getPhone());
                    existing.setGender(updatedEmployee.getGender());
                    existing.setLocation(updatedEmployee.getLocation());
                    existing.setNid(updatedEmployee.getNid());
                    existing.setUser(updatedEmployee.getUser());

                    Employee saved = employeeService.save(existing);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ employee delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeService.getById(id).isPresent()) {
            employeeService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

