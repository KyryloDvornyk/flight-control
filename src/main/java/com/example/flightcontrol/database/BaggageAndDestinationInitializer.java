package com.example.flightcontrol.database;

import com.example.flightcontrol.model.Baggage;
import com.example.flightcontrol.model.Destination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class BaggageAndDestinationInitializer {
    private final DatabaseImitation database;
    Logger logger = LoggerFactory.getLogger(BaggageAndDestinationInitializer.class);

    public BaggageAndDestinationInitializer(DatabaseImitation database) {
        this.database = database;
    }

    @PostConstruct
    public void insertData() {
        Destination destination1 = new Destination();
        destination1.setId(1L);
        database.getDestinations().add(destination1);
        Destination destination2 = new Destination();
        destination2.setId(2L);
        database.getDestinations().add(destination2);
        logger.info("Destinations with ids 1 and 2 was created.");
        Baggage baggage1 = new Baggage();
        baggage1.setId(1L);
        baggage1.setDestination(destination1);
        database.getBaggages().add(baggage1);
        Baggage baggage2 = new Baggage();
        baggage2.setId(2L);
        baggage2.setDestination(destination2);
        database.getBaggages().add(baggage2);
        logger.info("Baggeges with ids 1 and 2 and with destinations with following ids was created");
    }
}
