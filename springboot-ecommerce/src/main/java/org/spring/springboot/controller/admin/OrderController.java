//交易管理
package org.spring.springboot.controller.admin;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.spring.springboot.domain.Transaction;
import org.spring.springboot.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;



    @GetMapping("/orders")
    public String findByTransactionId(Long id, Model model) {

        model.addAttribute("path", "orders");

        return "admin/orders";
    }




}