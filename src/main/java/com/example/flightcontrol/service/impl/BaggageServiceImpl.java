package com.example.flightcontrol.service.impl;

import com.example.flightcontrol.dao.BaggageDao;
import com.example.flightcontrol.dto.response.BaggageCheckResponseDto;
import com.example.flightcontrol.model.Baggage;
import com.example.flightcontrol.service.BaggageService;
import org.springframework.stereotype.Service;

@Service
public class BaggageServiceImpl implements BaggageService {
    private final BaggageDao baggageDao;

    public BaggageServiceImpl(BaggageDao baggageDao) {
        this.baggageDao = baggageDao;
    }

    @Override
    public BaggageCheckResponseDto checkBaggage(Long baggageId, Long destinationId) {
        Baggage baggage = baggageDao.getById(baggageId).orElseThrow(()
                -> new RuntimeException("Baggage with id " + baggageId + " doesn't exist"));
        BaggageCheckResponseDto dto = new BaggageCheckResponseDto();
        dto.setIsInDestination(baggage.getDestination().getId().equals(destinationId));
        return dto;
    }
}
