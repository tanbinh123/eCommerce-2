package org.spring.springboot.controller.admin;


import org.spring.springboot.dao.master.CouponMarketDao;
import org.spring.springboot.domain.CouponMarket;
import org.spring.springboot.service.CouponMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class CouponMarketController {

    @Autowired
    private CouponMarketService couponMarketService;

    @Autowired
    private CouponMarketDao couponMarketDao;

    @GetMapping("/couponMarket")
    public String listAllCouponInMarket(Long couponId, Model model) {
        model.addAttribute("couponMarket", new CouponMarket());
        List<CouponMarket> list;
        if (couponId != null){
            model.addAttribute("host", "搜索结果");
            list = couponMarketService.findCouponMarketById(couponId);
        }else{
            model.addAttribute("host", "所有优惠券");
            list = couponMarketService.listAll();
        }
        model.addAttribute("list", list);
        return "admin/couponMarket";
    }



    @PostMapping("/couponMarket")
    public String userRegistrationOrUpdate(Model model, @ModelAttribute CouponMarket couponMarket) {
        if((couponMarket.getCouponId() == null)||couponMarket.getCouponQuantity() == null ){
            return "admin/inputWarning";
        }
        if(couponMarketService.findCouponMarketById(couponMarket.getCouponId()).isEmpty()){
            couponMarketService.saveCouponMarketId(couponMarket);
        }else{

            //test if posted in couponMarket's params are not null

            if(couponMarket.getCouponName() != null && couponMarket.getCouponName() != "" ) {
                couponMarketDao.updateCouponName(couponMarket.getCouponName(), couponMarket.getCouponId());
            }

            if(couponMarket.getCouponQuantity() != null) {
                couponMarketDao.updateQuantity(couponMarket.getCouponQuantity(), couponMarket.getCouponId());
            }

            if(couponMarket.getExpireDate() != null){
                //TODO
            }

            if(couponMarket.getCouponDescription() != null && couponMarket.getCouponDescription() != ""){
                couponMarketDao.updateDescription(couponMarket.getCouponDescription(), couponMarket.getCouponId());
            }

            couponMarketDao.updateOnsale(couponMarket.isCouponOnsale(), couponMarket.getCouponId());
            couponMarketDao.updateThresholdPrice(couponMarket.getEquivalentPrice(), couponMarket.getCouponId());
            couponMarketDao.updateEquivalentPrice(couponMarket.getEquivalentPrice(), couponMarket.getCouponId());

        }

        return "redirect:/couponMarket";
    }
//
//    @PostMapping("/couponMarketDelete")
//    public String deleteUser(Model model, @ModelAttribute User user) {
//        if(user.getId() == null){
//            return "admin/inputWarning";
//        }
//        couponMarketService.deleteUser(user.getId());
//        cityService.deleteCity(user.getId());
//        walletService.deleteWallet(user.getId());
//        return "redirect:/couponMarket";
//    }

}