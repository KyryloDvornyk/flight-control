package com.example.flightcontrol.service;

import com.example.flightcontrol.dto.response.TicketResponseDto;

public interface TicketService {
    TicketResponseDto checkIsAvailable(Long id);
}
