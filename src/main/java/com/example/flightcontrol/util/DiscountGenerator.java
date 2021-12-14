package com.example.flightcontrol.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiscountGenerator {
    private static List<Double> discounts = new ArrayList<>();
    private static Random random = new Random();

    static {
        discounts.add(0.1D);
        discounts.add(0.5D);
        discounts.add(0.6D);
    }

    public static Double getRandomDiscount() {
        return discounts.get(Math.abs(random.nextInt()) % 3);
    }
}
