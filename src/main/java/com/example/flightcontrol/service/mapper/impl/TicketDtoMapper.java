package com.example.flightcontrol.service.mapper.impl;

import com.example.flightcontrol.dto.response.TicketResponseDto;
import com.example.flightcontrol.model.Ticket;
import com.example.flightcontrol.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoMapper implements ResponseDtoMapper<Ticket, TicketResponseDto> {
    @Override
    public TicketResponseDto mapToDto(Ticket model) {
        TicketResponseDto dto = new TicketResponseDto();
        dto.setIsAvailable(model.getIsAvailable());
        return dto;
    }
}
