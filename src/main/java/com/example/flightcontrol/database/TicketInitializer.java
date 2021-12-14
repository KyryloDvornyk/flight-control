package com.example.flightcontrol.database;

import com.example.flightcontrol.model.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class TicketInitializer {
    private final DatabaseImitation database;
    Logger logger = LoggerFactory.getLogger(BaggageAndDestinationInitializer.class);

    public TicketInitializer(DatabaseImitation database) {
        this.database = database;
    }

    @PostConstruct
    public void insertData() {
        Ticket ticketAvailable = new Ticket();
        ticketAvailable.setId(1L);
        ticketAvailable.setIsAvailable(true);
        database.getTickets().add(ticketAvailable);
        Ticket ticketNotAvailable = new Ticket();
        ticketNotAvailable.setId(2L);
        ticketNotAvailable.setIsAvailable(false);
        database.getTickets().add(ticketNotAvailable);
        logger.info("Tickets with id 1, available and id 2, unavailable was created");
    }
}
