package com.example.flightcontrol.dao.impl;

import java.util.Optional;
import com.example.flightcontrol.dao.TicketDao;
import com.example.flightcontrol.database.DatabaseImitation;
import com.example.flightcontrol.model.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao {
    private final DatabaseImitation database;

    public TicketDaoImpl(DatabaseImitation database) {
        this.database = database;
    }

    @Override
    public Optional<Ticket> getById(Long id) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getId().equals(id)) {
                return Optional.of(ticket);
            }
        }
        return Optional.empty();
    }
}
