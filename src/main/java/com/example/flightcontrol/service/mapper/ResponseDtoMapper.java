package com.example.flightcontrol.service.mapper;

public interface ResponseDtoMapper<M, D> {
    D mapToDto(M model);
}
