package org.spring.springboot.controller.userInterface;

//主页
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
//@RequestMapping("/userInterface")
public class UINavigatorController {

    @GetMapping("/userInterface")
    public String navigator(Model model) {
        return "userInterface/navigator";
    }



}