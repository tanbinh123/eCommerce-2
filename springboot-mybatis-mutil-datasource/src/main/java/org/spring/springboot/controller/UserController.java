package org.spring.springboot.controller;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/helloworld")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/userList")
    public String userList(ModelMap map) {
        map.addAttribute("host", "User list");
        List<User> List = userService.listAll();
        map.addAttribute("List", List);
        return "user/userList";
    }

}