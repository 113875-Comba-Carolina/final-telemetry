package ar.edu.utn.frc.tup.lciii.controllers;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.utn.frc.tup.lciii.dtos.common.request.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.services.TelemetryService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TelemetryController {
    private final TelemetryService telemetryService;

    @PostMapping("/telemetry")
    public ResponseEntity<?> saveTelemetry(@RequestBody TelemetryDto telemetryDto) {
        return new ResponseEntity<>(telemetryService.saveTelemetry(telemetryDto), HttpStatus.CREATED);
    }


}