package com.example.flightcontrol.dao.impl;

import java.util.Optional;
import com.example.flightcontrol.dao.CouponDao;
import com.example.flightcontrol.database.DatabaseImitation;
import com.example.flightcontrol.model.Coupon;
import org.springframework.stereotype.Repository;

@Repository
public class CouponDaoImpl implements CouponDao {
    private final DatabaseImitation database;

    public CouponDaoImpl(DatabaseImitation database) {
        this.database = database;
    }

    @Override
    public Optional<Coupon> getById(Long id) {
        for (Coupon coupon : database.getCoupons()) {
            if (coupon.getId().equals(id)) {
                return Optional.of(coupon);
            }
        }
        return Optional.empty();
    }
}
