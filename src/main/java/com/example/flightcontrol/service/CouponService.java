package com.example.flightcontrol.service;

import com.example.flightcontrol.dto.response.CouponResponseDto;

public interface CouponService {
    CouponResponseDto getPriceByCoupon(Long id, Double price);
}
