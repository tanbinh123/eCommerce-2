package org.spring.springboot.domain;

import java.util.Date;

/**
 * 实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class CouponMarket {

    private Long couponId;

    private String couponName;

    private String couponDescription;

    private boolean couponOnsale;

    private double thresholdPrice;

    private double equivalentPrice;

    private long couponQuantity;

    private Date expireDate;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    public void setCouponDescription(String couponDescription) {
        this.couponDescription = couponDescription;
    }

    public boolean isCouponOnsale() {
        return couponOnsale;
    }

    public void setCouponOnsale(boolean couponOnsale) {
        this.couponOnsale = couponOnsale;
    }

    public double getThresholdPrice() {
        return thresholdPrice;
    }

    public void setThresholdPrice(double thresholdPrice) {
        this.thresholdPrice = thresholdPrice;
    }

    public double getEquivalentPrice() {
        return equivalentPrice;
    }

    public void setEquivalentPrice(double equivalentPrice) {
        this.equivalentPrice = equivalentPrice;
    }

    public long getCouponQuantity() {
        return couponQuantity;
    }

    public void setCouponQuantity(int couponQuantity) {
        this.couponQuantity = couponQuantity;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
