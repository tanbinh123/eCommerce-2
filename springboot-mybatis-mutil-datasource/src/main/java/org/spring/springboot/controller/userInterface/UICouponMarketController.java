//优惠券市场管理
package org.spring.springboot.controller.userInterface;


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
@RequestMapping("/userInterface")
public class UICouponMarketController {

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
        return "userInterface/couponMarket";
    }



    @PostMapping("/couponMarket")
    public String userRegistrationOrUpdate(Model model, @ModelAttribute CouponMarket couponMarket) {
        if((couponMarket.getCouponId() == null)||couponMarket.getCouponQuantity() == null ){
            return "userInterface/inputWarning";
        }
        //test if update or insert
        if(couponMarketService.findCouponMarketById(couponMarket.getCouponId()).isEmpty()){
            //insert
            couponMarketService.saveCouponMarketId(couponMarket);
        }else{
            //update
            couponMarketService.updateCouponMarketById(couponMarket);
        }
        return "redirect:/userInterface/couponMarket";
    }

    @PostMapping("/couponMarketDelete")
    public String deleteUser(Model model, @ModelAttribute CouponMarket couponMarket) {
        if(couponMarket.getCouponId() == null){
            return "userInterface/inputWarning";
        }
        couponMarketService.deleteCouponMarket(couponMarket.getCouponId());
        return "redirect:/userInterface/couponMarket";
    }

}