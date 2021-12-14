package com.example.flightcontrol.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.flightcontrol.database.DatabaseImitation;
import com.example.flightcontrol.model.Baggage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaggageDaoTest {
    @Mock
    private DatabaseImitation database;
    @InjectMocks
    private BaggageDaoImpl baggageDao;

    @Test
    public void getById_WithData_Ok() {
        List<Baggage> baggages = new ArrayList<>();
        Baggage baggage1 = new Baggage();
        baggage1.setId(1L);
        baggages.add(baggage1);
        Baggage baggage2 = new Baggage();
        baggage2.setId(2L);
        baggages.add(baggage2);
        Mockito.when(database.getBaggages()).thenReturn(baggages);
        Optional<Baggage> baggage = baggageDao.getById(2L);
        Assertions.assertEquals(baggage.get(), baggage2);
    }

    @Test
    public void getById_WithoutData_Ok() {
        Mockito.when(database.getBaggages()).thenReturn(new ArrayList<>());
        Optional<Baggage> baggage = baggageDao.getById(1L);
        Assertions.assertEquals(baggage, Optional.empty());
    }
}