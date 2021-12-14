package com.example.flightcontrol.service.impl;

import com.example.flightcontrol.dao.CouponDao;
import com.example.flightcontrol.dto.response.CouponResponseDto;
import com.example.flightcontrol.service.CouponService;
import com.example.flightcontrol.util.DiscountGenerator;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {
    private final CouponDao couponDao;

    public CouponServiceImpl(CouponDao couponDao) {
        this.couponDao = couponDao;
    }

    @Override
    public CouponResponseDto getPriceByCoupon(Long id, Double price) {
        couponDao.getById(id).orElseThrow(()
                -> new RuntimeException("Coupon with id " + id + " doesn't exist"));
        CouponResponseDto dto = new CouponResponseDto();
        dto.setNewPrice(price - price * DiscountGenerator.getRandomDiscount());
        return dto;
    }
}
