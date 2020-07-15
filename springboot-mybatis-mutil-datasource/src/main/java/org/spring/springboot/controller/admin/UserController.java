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

    @GetMapping("/user")
    public String listAllUsers(Long id, Model model) {

        model.addAttribute("user", new User());
        List<User> List;
        if (id != null){
            model.addAttribute("host", "搜索结果");
            List = userService.findById(id);
        }else{
            model.addAttribute("host", "所有用户");
            List = userService.findByName("%");
        }
        userService.setCity(List);
        model.addAttribute("List", List);
        return "admin/user";
    }

//    @GetMapping("/user/{id}")
//    public String findUsers(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("host", "搜索结果");
//        model.addAttribute("user", new User());
//        List<User> List;
//        List = userService.findById(id);
//        userService.setCity(List);
//        model.addAttribute("List", List);
//        return "admin/user";
//    }

    @PostMapping("/user")
    public String userRegistration(Model model, @ModelAttribute User user) {
//        if(user.getId() != null){
//            userService.findById(user.getId());
//        }else if (user.getUserName().equals("")) {
//            userService.findByName("%");
//        }else{
//            userService.findByName(user.getUserName());
//        }


        return "redirect:/user";
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