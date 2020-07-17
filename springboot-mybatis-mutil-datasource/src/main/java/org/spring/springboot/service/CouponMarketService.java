package org.spring.springboot.service;

import org.spring.springboot.domain.CouponMarket;

import java.util.List;

/**
 * 业务逻辑接口类
 *
 */
public interface CouponMarketService {



    CouponMarket findCouponMarketById(Long id);

    Long saveCouponMarket(CouponMarket couponMarket);

    List<CouponMarket> listAll();

    Long deleteCouponMarket(Long id);


}
