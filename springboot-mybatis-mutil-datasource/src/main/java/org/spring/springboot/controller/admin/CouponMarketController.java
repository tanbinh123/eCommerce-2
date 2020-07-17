package org.spring.springboot.controller.admin;


import org.spring.springboot.dao.master.CouponMarketDao;
import org.spring.springboot.domain.CouponMarket;
import org.spring.springboot.service.CouponMarketService;
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
public class CouponMarketController {

    @Autowired
    private CouponMarketService couponMarketService;


    @GetMapping("/couponMarket")
    public String listAllCouponInMarket(Long id, Model model) {
        model.addAttribute("coupon", new CouponMarket());
        List<CouponMarket> list;
        if (id != null){
            model.addAttribute("host", "搜索结果");
            list = couponMarketService.listAll();
        }else{
            model.addAttribute("host", "所有优惠券");
            list = couponMarketService.listAll();
        }
//        System.out.println(list.toString());
        model.addAttribute("list", list);
        return "admin/couponMarket";
    }



//    @PostMapping("/couponMarket")
//    public String userRegistrationOrUpdate(Model model, @ModelAttribute User user) {
//        if(user.getId() == null){
//            return "admin/inputWarning";
//        }
//        if(userService.findById(user.getId()).isEmpty()){
//            userService.saveUser(user);
//            //create city
//            user.getCity().setId(user.getId());
//            cityService.saveCity(user.getCity());
//            //create wallet
//            Wallet wallet = new Wallet();
//            wallet.setId(user.getId());
//            wallet.setAsset(0);
//            walletService.saveWallet(wallet);
//        }else{
//            City cityInDB = cityService.findCityById(user.getId());
//            //test if city's param is not all null
//            if(user.getUserName() != null && user.getUserName() != "") {
//                userService.updateUser(user);
//            }
//            //test if city's param is not all null
//            user.getCity().setId(user.getId());
//
//            if(user.getCity().getAddress() != null && user.getCity().getAddress() != "" ) {
//                cityDao.updateAddress(user.getCity().getAddress(), user.getId());
//            }
//            if(user.getCity().getCityName() != null && user.getCity().getCityName() != "") {
//                cityDao.updateCityName(user.getCity().getCityName(),user.getId());
//
//            }
//            if(user.getCity().getProvinceId() != null){
//                cityDao.updateProvinceId(user.getCity().getProvinceId(), user.getId());
//            }
//            if(user.getCity().getDescription() != null && user.getCity().getDescription() != ""){
//                cityDao.updateDescription(user.getCity().getDescription(), user.getId());
//            }
//            if(user.getCity().getPhoneNumber() != null){
//                cityDao.updatePhoneNumber(user.getCity().getPhoneNumber(), user.getId());
//            }
//
//        }
//
//        return "redirect:/couponMarket";
//    }
//
//    @PostMapping("/couponMarketDelete")
//    public String deleteUser(Model model, @ModelAttribute User user) {
//        if(user.getId() == null){
//            return "admin/inputWarning";
//        }
//        userService.deleteUser(user.getId());
//        cityService.deleteCity(user.getId());
//        walletService.deleteWallet(user.getId());
//        return "redirect:/couponMarket";
//    }

}