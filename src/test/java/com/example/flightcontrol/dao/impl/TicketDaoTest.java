package com.example.flightcontrol.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.flightcontrol.database.DatabaseImitation;
import com.example.flightcontrol.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TicketDaoTest {
    @Mock
    private DatabaseImitation database;
    @InjectMocks
    private TicketDaoImpl ticketDao;

    @Test
    public void getById_WithData_Ok() {
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = new Ticket();
        ticket1.setIsAvailable(true);
        ticket1.setId(1L);
        tickets.add(ticket1);
        Ticket ticket2 = new Ticket();
        ticket2.setIsAvailable(false);
        ticket2.setId(2L);
        tickets.add(ticket2);
        Mockito.when(database.getTickets()).thenReturn(tickets);
        Optional<Ticket> ticket = ticketDao.getById(2L);
        Assertions.assertEquals(ticket.get(), ticket2);
    }

    @Test
    public void getById_WithoutData_Ok() {
        Mockito.when(database.getTickets()).thenReturn(new ArrayList<>());
        Optional<Ticket> ticket = ticketDao.getById(1L);
        Assertions.assertEquals(ticket, Optional.empty());
    }
}