package org.spring.springboot.service.impl;

import org.spring.springboot.dao.master.CouponMarketDao;
import org.spring.springboot.domain.CouponMarket;
import org.spring.springboot.service.CouponMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务逻辑实现类
 *
 */
@Service
public class CouponMarketServiceImpl implements CouponMarketService {

    @Autowired
    private CouponMarketDao couponMarketDao;

    @Override
    public CouponMarket findCouponMarketById(Long id) {
        return null;
    }

    @Override
    public Long saveCouponMarket(CouponMarket couponMarket) {
        return null;
    }

    @Override
    public List<CouponMarket> listAll() {
        return couponMarketDao.listAll();
    }

    @Override
    public Long deleteCouponMarket(Long id) {
        return null;
    }

}
