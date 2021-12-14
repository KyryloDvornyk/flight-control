package com.example.flightcontrol.service.impl;

import java.util.Optional;
import com.example.flightcontrol.dao.BaggageDao;
import com.example.flightcontrol.dto.response.BaggageCheckResponseDto;
import com.example.flightcontrol.model.Baggage;
import com.example.flightcontrol.model.Destination;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaggageServiceTest {
    @Mock
    private BaggageDao baggageDao;
    @InjectMocks
    private BaggageServiceImpl baggageService;

    @Test
    public void checkBaggage_WithBaggage_Ok() {
        Baggage baggage = new Baggage();
        baggage.setId(1L);
        Destination destination = new Destination();
        destination.setId(1L);
        baggage.setDestination(destination);
        Mockito.when(baggageDao.getById(Mockito.any())).thenReturn(Optional.of(baggage));
        BaggageCheckResponseDto dto = baggageService.checkBaggage(1L, 1L);
        Assertions.assertTrue(dto.getIsInDestination());
    }

    @Test
    public void checkBaggage_WithoutBaggage_NotOk() {
        Mockito.when(baggageDao.getById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class, ()
                -> baggageService.checkBaggage(1L, 1L));
    }
}