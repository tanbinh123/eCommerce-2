package org.spring.springboot.controller.admin;

import org.spring.springboot.domain.Greeting;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public String listAllUsers(Model model) {
        model.addAttribute("host", "List of all users");
        model.addAttribute("user", new User());
        List<User> List;
        List = userService.findByName("%");
        model.addAttribute("List", List);
        return "admin/userList";
    }

    @PostMapping("/userList")
    public String findByIdOrName(Model model, @ModelAttribute User user) {
        model.addAttribute("host", "Searching results");
        List<User> List;
        if(user.getId() != null){
            List = userService.findById(user.getId());
        }else if (user.getUserName().equals("")) {
            List = userService.findByName("%");
        }else{
            List = userService.findByName(user.getUserName());
        }
        model.addAttribute("List", List);
        return "admin/userList";
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }


}