package ar.edu.utn.frc.tup.lciii.services;

import org.springframework.stereotype.Service;

import ar.edu.utn.frc.tup.lciii.dtos.common.request.TelemetryDto;

@Service
public interface TelemetryService {

    Object saveTelemetry(TelemetryDto telemetryDto);
}
