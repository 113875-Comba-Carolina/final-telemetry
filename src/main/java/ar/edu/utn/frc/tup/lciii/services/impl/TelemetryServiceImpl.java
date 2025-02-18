package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.common.response.TelemetryDtoResponse;
import org.springframework.stereotype.Service;

import ar.edu.utn.frc.tup.lciii.dtos.common.request.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import ar.edu.utn.frc.tup.lciii.repositories.TelemetryRepository;
import ar.edu.utn.frc.tup.lciii.services.DeviceService;
import ar.edu.utn.frc.tup.lciii.services.TelemetryService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TelemetryServiceImpl implements TelemetryService {

    private final DeviceService deviceService;

    private final TelemetryRepository telemetryRepository;

    @Override
    public TelemetryDtoResponse saveTelemetry(TelemetryDto telemetryDto) {
        Device device = deviceService.getDeviceByHostName(telemetryDto.getHostName());
        Telemetry telemetry = new Telemetry();
        if(device != null) {
            telemetry.setDevice(device);
        } else {
            throw new RuntimeException("Device not found");
        }
        telemetry.setIp(telemetryDto.getIp());
        telemetry.setDataDate(LocalDateTime.now());
        telemetry.setCpuUsage(telemetryDto.getHostDiskFree());
        telemetry.setMicrophoneState(telemetryDto.getMicrophoneState());
        telemetry.setScreenCaptureAllowed(telemetryDto.getScreenCaptureAllowed());
        telemetry.setAudioCaptureAllowed(telemetryDto.getAudioCaptureAllowed());
        telemetryRepository.save(telemetry);
        return new TelemetryDtoResponse(telemetry.getDevice().getHostName(), telemetry.getIp(), telemetry.getCpuUsage(),
                telemetry.getMicrophoneState(), telemetry.getScreenCaptureAllowed(), telemetry.getAudioCaptureAllowed(),
                telemetry.getDataDate());
    }

    @Override
    public List<TelemetryDtoResponse> getAllTelemetries() {
        List<Telemetry> telemetries = telemetryRepository.findAll();
        List<TelemetryDtoResponse> telemetryDtoResponses = new ArrayList<>();
        for(Telemetry telemetry : telemetries) {
            telemetryDtoResponses.add(new TelemetryDtoResponse(telemetry.getDevice().getHostName(), telemetry.getIp(),
                    telemetry.getCpuUsage(), telemetry.getMicrophoneState(), telemetry.getScreenCaptureAllowed(),
                    telemetry.getAudioCaptureAllowed(), telemetry.getDataDate()));
        }
        return telemetryDtoResponses;
    }
}
