package com.example.flightcontrol.database;

import java.util.ArrayList;
import java.util.List;
import com.example.flightcontrol.model.Baggage;
import com.example.flightcontrol.model.Coupon;
import com.example.flightcontrol.model.Destination;
import com.example.flightcontrol.model.Ticket;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DatabaseImitation {
    private final List<Ticket> tickets = new ArrayList<>();
    private final List<Destination> destinations = new ArrayList<>();
    private final List<Baggage> baggages = new ArrayList<>();
    private final List<Coupon> coupons = new ArrayList<>();
}
