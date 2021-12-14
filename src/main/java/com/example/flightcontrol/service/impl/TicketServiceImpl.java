package com.example.flightcontrol.service.impl;

import com.example.flightcontrol.dao.TicketDao;
import com.example.flightcontrol.dto.response.TicketResponseDto;
import com.example.flightcontrol.model.Ticket;
import com.example.flightcontrol.service.TicketService;
import com.example.flightcontrol.service.mapper.impl.TicketDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketDao ticketDao;
    private final TicketDtoMapper ticketDtoMapper;

    public TicketServiceImpl(TicketDao ticketDao, TicketDtoMapper ticketDtoMapper) {
        this.ticketDao = ticketDao;
        this.ticketDtoMapper = ticketDtoMapper;
    }

    @Override
    public TicketResponseDto checkIsAvailable(Long id) {
        Ticket ticket = ticketDao.getById(id).orElseThrow(() ->
                new RuntimeException("Ticket with id " + id + " doesn't  exist."));
        return ticketDtoMapper.mapToDto(ticket);
    }
}
