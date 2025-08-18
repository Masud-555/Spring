package com.emranhss.restuarent.service;

import com.emranhss.restuarent.entity.Employee;
import com.emranhss.restuarent.entity.Menu;
import com.emranhss.restuarent.repository.IMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {


    @Autowired
    private IMenuRepository menuRepository;


    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getById(Long id) {
        return menuRepository.findById(id);
    }

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    public void delete(Long id) {
        menuRepository.deleteById(id);
    }
}
