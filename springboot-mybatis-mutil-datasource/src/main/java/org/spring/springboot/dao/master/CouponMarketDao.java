package org.spring.springboot.dao.master;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.CouponMarket;

import java.util.List;

/**
 * 城市 DAO 接口类
 *
 */
@Mapper
public interface CouponMarketDao {

    List<CouponMarket> listAll();

//    CouponMarket findById(@Param("id") Long id);
//
//    Long saveCoupon(CouponMarket coupon);
//
//    Long updateCoupon(CouponMarket coupon);
//
//    Long deleteCoupon(Long id);
//
//    @Update("UPDATE coupon SET coupon_name = #{couponName} WHERE id = #{userId}")
//    int updateCouponName(@Param("couponName") String couponName, @Param("userId") long userId);
//
//    @Update("UPDATE coupon SET address = #{address} WHERE id = #{userId}")
//    int updateAddress(@Param("address") String address, @Param("userId") long userId);
//
//    @Update("UPDATE coupon SET description = #{description} WHERE id = #{userId}")
//    int updateDescription(@Param("description") String description, @Param("userId") long userId);
//
//    @Update("UPDATE coupon SET province_id = #{provinceId} WHERE id = #{userId}")
//    int updateProvinceId(@Param("provinceId") Long provinceId, @Param("userId") long userId);
//
//    @Update("UPDATE coupon SET phonenumber = #{phoneNumber} WHERE id = #{userId}")
//    int updatePhoneNumber(@Param("phoneNumber") Long phoneNumber, @Param("userId") long userId);


}
