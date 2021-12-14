package com.example.flightcontrol.service.impl;

import java.util.Optional;
import com.example.flightcontrol.dao.CouponDao;
import com.example.flightcontrol.dto.response.CouponResponseDto;
import com.example.flightcontrol.model.Coupon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CouponServiceTest {
    @Mock
    private CouponDao couponDao;
    @InjectMocks
    private CouponServiceImpl couponService;

    @Test
    public void getPriceByCoupon_WithCoupon_Ok() {
        Mockito.when(couponDao.getById(Mockito.any())).thenReturn(Optional.of(new Coupon()));
        CouponResponseDto dto = couponService.getPriceByCoupon(1L, 10D);
        Assertions.assertTrue(dto.getNewPrice() >= 4D);
        Assertions.assertTrue(dto.getNewPrice() <= 9D);
    }

    @Test
    public void getPriceByCoupon_WithoutCoupon_NotOk() {
        Mockito.when(couponDao.getById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class, ()
                -> couponService.getPriceByCoupon(1L, 10D));
    }
}