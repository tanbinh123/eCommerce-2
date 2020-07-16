package org.spring.springboot.controller.admin;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.spring.springboot.domain.Transaction;
import org.spring.springboot.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class TransactionController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;


    @GetMapping("/transaction")
    public String findByTransactionId(Long id, Model model) {

        model.addAttribute("transaction", new Transaction());
        List<Transaction> List;
        if (id != null){
            model.addAttribute("host", "搜索结果");
            List = transactionService.findByTransactionId(id);
        }
        else{
            model.addAttribute("host", "所有交易");
            List = transactionService.findAll();
        }

        model.addAttribute("List", List);
        return "admin/transaction";

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

//    @PostMapping("/user")
//    public String userRegistration(Model model, @ModelAttribute User user) {
//        if(user.getId() == null){
//            return "admin/inputWarning";
//        }
//        else if(!userService.findById(user.getId()).isEmpty()){
//            return "admin/inputWarning";
//        }
//
//        userService.saveUser(user);
//        //create city
//        City city = new City();
//        city.setId(user.getId());
//        cityService.saveCity(city);
//        //create wallet
//        Wallet wallet = new Wallet();
//        wallet.setId(user.getId());
//        wallet.setAsset(0);
//        walletService.saveWallet(wallet);
//        return "redirect:/user";
//    }



}