package org.spring.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/")
public class HomepageController {


    @GetMapping("/")
    public String findById(Long id, Model model) {

        return "admin/homepage";

    }



}