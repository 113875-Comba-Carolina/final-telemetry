package ar.edu.utn.frc.tup.lciii.services;

import org.springframework.stereotype.Service;

import ar.edu.utn.frc.tup.lciii.dtos.common.request.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.dtos.common.response.TelemetryDtoResponse;

import java.util.List;

@Service
public interface TelemetryService {

    TelemetryDtoResponse saveTelemetry(TelemetryDto telemetryDto);

    List<TelemetryDtoResponse> getAllTelemetries();
}
