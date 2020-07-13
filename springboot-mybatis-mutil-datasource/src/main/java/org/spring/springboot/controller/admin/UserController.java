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




//    @RequestMapping("/userList")
//    public String userList2(ModelMap map) {
//        map.addAttribute("host", "User list");
//        List<User> List = userService.listAll();
//        map.addAttribute("List", List);
//        return "admin/userList";
//    }

    @GetMapping("/userList")
    public String listAllUsers(Model model) {
        model.addAttribute("host", "User list");
        List<User> List = userService.listAll();
        model.addAttribute("List", List);
        model.addAttribute("user", new User());
        return "admin/userList";
    }

    @PostMapping("/userList")
    public String findByName(Model model, @ModelAttribute User user) {
        String myUserName = user.getUserName();
        List<User> List;
        List = new ArrayList<User>();
        List.add(userService.findByName(myUserName));
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