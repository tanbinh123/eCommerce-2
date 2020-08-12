package org.spring.springboot.controller.userInterface;

//主页
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/userInterface")
public class UIIndexController {

    @GetMapping("/index")
    public String homepage(Model model) {

        return "userInterface/index";

    }



}