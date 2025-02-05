package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.common.request.TelemetryDto;

public interface TelemetryService {

    TelemetryDto saveTelemetry(TelemetryDto telemetryDto);
}
