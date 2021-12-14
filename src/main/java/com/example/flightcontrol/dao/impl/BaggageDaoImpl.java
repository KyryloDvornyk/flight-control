package com.example.flightcontrol.dao.impl;

import java.util.Optional;
import com.example.flightcontrol.dao.BaggageDao;
import com.example.flightcontrol.database.DatabaseImitation;
import com.example.flightcontrol.model.Baggage;
import org.springframework.stereotype.Repository;

@Repository
public class BaggageDaoImpl implements BaggageDao {
    private final DatabaseImitation database;

    public BaggageDaoImpl(DatabaseImitation database) {
        this.database = database;
    }

    @Override
    public Optional<Baggage> getById(Long id) {
        for (Baggage baggage : database.getBaggages()) {
            if (baggage.getId().equals(id)) {
                return Optional.of(baggage);
            }
        }
        return Optional.empty();
    }
}
