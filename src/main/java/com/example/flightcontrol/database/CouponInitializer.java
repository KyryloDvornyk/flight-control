package com.example.flightcontrol.database;

import com.example.flightcontrol.model.Coupon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class CouponInitializer {
    private final DatabaseImitation database;
    Logger logger = LoggerFactory.getLogger(BaggageAndDestinationInitializer.class);

    public CouponInitializer(DatabaseImitation database) {
        this.database = database;
    }

    @PostConstruct
    public void insertData() {
        Coupon coupon1 = new Coupon();
        coupon1.setId(1L);
        database.getCoupons().add(coupon1);
        Coupon coupon2 = new Coupon();
        coupon2.setId(2L);
        database.getCoupons().add(coupon2);
        logger.info("Coupons with ids 1 and 2 was created");
    }
}
