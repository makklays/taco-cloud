package com.techmatrix18.web;

import com.techmatrix18.data.OrderAdminService;
import com.techmatrix18.data.OrderRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private OrderAdminService adminService;
    private OrderRepository orderRepository;

    public AdminController(OrderAdminService adminService) {
        this.adminService = adminService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/deleteOrders")
    public String deleteAllOrders() {
        adminService.deleteAllOrders();

        return "redirect:/admin";
    }

    /*public void deleteAllOrders() {
        orderRepository.deleteAll();
    }*/
}

