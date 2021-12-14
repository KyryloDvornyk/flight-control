package com.example.flightcontrol.controller;

import com.example.flightcontrol.dto.response.CouponResponseDto;
import com.example.flightcontrol.service.CouponService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/coupons")
@Validated
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/{id}")
    public CouponResponseDto getPriceByCoupon(@PathVariable @Min(1) Long id,
                                              @RequestParam @Min(1) Double price) {
        return couponService.getPriceByCoupon(id, price);
    }
}
