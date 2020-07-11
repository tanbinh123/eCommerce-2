package org.spring.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    
    @ResponseBody
    @RequestMapping("/helloworld")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/HELLO")
    public String index(ModelMap map) {
        map.addAttribute("host", "HELLO");
        return "hello";
    }

}