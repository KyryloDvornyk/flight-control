package com.example.flightcontrol.controller;

import com.example.flightcontrol.dto.response.BaggageCheckResponseDto;
import com.example.flightcontrol.service.BaggageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/baggages")
@Validated
public class BaggageController {
    private final BaggageService baggageService;

    public BaggageController(BaggageService baggageService) {
        this.baggageService = baggageService;
    }

    @GetMapping("/check-in")
    public BaggageCheckResponseDto checkBaggage(@RequestParam @Min(1) Long baggageId,
                                                @RequestParam @Min(1) Long destinationId) {
        return baggageService.checkBaggage(baggageId, destinationId);
    }
}
