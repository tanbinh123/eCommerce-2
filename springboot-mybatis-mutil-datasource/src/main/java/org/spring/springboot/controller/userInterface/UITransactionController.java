//交易管理
package org.spring.springboot.controller.userInterface;

import org.spring.springboot.domain.Transaction;
import org.spring.springboot.service.TransactionService;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/userInterface")
public class UITransactionController {

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
        return "userInterface/transaction";
    }

    @GetMapping("/transaction/payer_id")
    public String findByPayerId(Long payer_id, Model model) {
        model.addAttribute("transaction", new Transaction());
        List<Transaction> List;
        if (payer_id != null){
            model.addAttribute("host", "搜索结果");
            List = transactionService.findByPayerId(payer_id);
        }
        else{
            model.addAttribute("host", "所有交易");
            List = transactionService.findAll();
        }
        model.addAttribute("List", List);
        return "userInterface/transaction";
    }

    @GetMapping("/transaction/receiver_id")
    public String findByReceiverId(Long receiver_id, Model model) {
        model.addAttribute("transaction", new Transaction());
        List<Transaction> List;
        if (receiver_id != null){
            model.addAttribute("host", "搜索结果");
            List = transactionService.findByReceiverId(receiver_id);
        }
        else{
            model.addAttribute("host", "所有交易");
            List = transactionService.findAll();
        }
        model.addAttribute("List", List);
        return "userInterface/transaction";
    }

//    @GetMapping("/userInterface/{id}")
//    public String findUsers(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("host", "搜索结果");
//        model.addAttribute("userInterface", new User());
//        List<User> List;
//        List = userService.findById(id);
//        userService.setCity(List);
//        model.addAttribute("List", List);
//        return "userInterface/userInterface";
//    }

//    @PostMapping("/userInterface")
//    public String userRegistration(Model model, @ModelAttribute User userInterface) {
//        if(userInterface.getId() == null){
//            return "userInterface/inputWarning";
//        }
//        else if(!userService.findById(userInterface.getId()).isEmpty()){
//            return "userInterface/inputWarning";
//        }
//
//        userService.saveUser(userInterface);
//        //create city
//        City city = new City();
//        city.setId(userInterface.getId());
//        cityService.saveCity(city);
//        //create wallet
//        Wallet wallet = new Wallet();
//        wallet.setId(userInterface.getId());
//        wallet.setAsset(0);
//        walletService.saveWallet(wallet);
//        return "redirect:/userInterface";
//    }



}