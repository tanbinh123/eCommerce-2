//用户管理
package org.spring.springboot.controller.admin;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.spring.springboot.domain.Wallet;
import org.spring.springboot.service.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private WalletService walletService;

    @GetMapping("/users")
    public String listAllUsers(Long id, Model model) {
        model.addAttribute("path", "users");
        return "admin/users";
    }

//    @GetMapping("/customer/{id}")
//    public String findUsers(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("host", "搜索结果");
//        model.addAttribute("customer", new User());
//        List<User> List;
//        List = userService.findById(id);
//        userService.setCity(List);
//        model.addAttribute("List", List);
//        return "admin/customer";
//    }

    @PostMapping("/users")
    public String userRegistrationOrUpdate(Model model, @ModelAttribute User user) {
        if(user.getId() == null){
            return "admin/inputWarning";
        }



        return "redirect:/admin/users";
    }

    @PostMapping("/userDelete")
    public String deleteUser(Model model, @ModelAttribute User user) {
        if(user.getId() == null){
            return "admin/inputWarning";
        }
        userService.deleteUser(user.getId());
        walletService.deleteWallet(user.getId());
        return "redirect:/admin/user";
    }

}