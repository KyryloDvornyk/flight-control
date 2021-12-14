package com.example.flightcontrol.dao;

import java.util.Optional;

public interface ModelDao<M> {
    Optional<M> getById(Long id);
}
