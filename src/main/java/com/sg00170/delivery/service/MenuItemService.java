package com.sg00170.delivery.service;

import com.sg00170.delivery.exception.NotFoundException;
import com.sg00170.delivery.model.MenuItem;
import com.sg00170.delivery.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem findById(Long id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("MenuItem not found"));
    }
}
