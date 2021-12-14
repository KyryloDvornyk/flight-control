package com.example.flightcontrol.service;

import com.example.flightcontrol.dto.response.BaggageCheckResponseDto;

public interface BaggageService {
    BaggageCheckResponseDto checkBaggage(Long baggageId, Long destinationId);
}
