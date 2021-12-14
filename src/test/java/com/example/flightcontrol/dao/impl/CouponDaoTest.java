package com.example.flightcontrol.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.flightcontrol.database.DatabaseImitation;
import com.example.flightcontrol.model.Coupon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CouponDaoTest {
    @Mock
    private DatabaseImitation database;
    @InjectMocks
    private CouponDaoImpl couponDao;

    @Test
    public void getById_WithData_Ok() {
        List<Coupon> coupons = new ArrayList<>();
        Coupon coupon1 = new Coupon();
        coupon1.setId(1L);
        coupons.add(coupon1);
        Coupon coupon2 = new Coupon();
        coupon2.setId(2L);
        coupons.add(coupon2);
        Mockito.when(database.getCoupons()).thenReturn(coupons);
        Optional<Coupon> coupon = couponDao.getById(2L);
        Assertions.assertEquals(coupon.get(), coupon2);
    }

    @Test
    public void getById_WithoutData_Ok() {
        Mockito.when(database.getCoupons()).thenReturn(new ArrayList<>());
        Optional<Coupon> coupon = couponDao.getById(1L);
        Assertions.assertEquals(coupon, Optional.empty());
    }
}