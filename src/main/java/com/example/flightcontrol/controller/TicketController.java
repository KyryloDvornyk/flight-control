package com.example.flightcontrol.controller;

import com.example.flightcontrol.dto.response.TicketResponseDto;
import com.example.flightcontrol.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/is-available/{id}")
    public TicketResponseDto isAvailable(@PathVariable @Min(1) Long id) {
        return ticketService.checkIsAvailable(id);
    }
}
