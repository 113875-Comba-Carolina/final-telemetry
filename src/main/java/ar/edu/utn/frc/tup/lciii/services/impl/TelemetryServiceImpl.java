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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TelemetryServiceImpl implements TelemetryService {

    private final DeviceService deviceService;

    private final TelemetryRepository telemetryRepository;

    @Override
    public Object saveTelemetry(TelemetryDto telemetryDto) {
        Device device = deviceService.getDeviceByName(telemetryDto.getHostname());
        if(device == null){
            throw new RuntimeException("Device not found");
        }
        Telemetry telemetry = new Telemetry();
        telemetry.setCpuUsage(telemetryDto.getCpuUsage());
        telemetry.setDevice(device);
        telemetry.setDataDate(telemetryDto.getDataDate());
        telemetry.setAudioCaptureAllowed(telemetryDto.getAudioCaptureAllowed());
        telemetry.setScreenCaptureAllowed(telemetryDto.getScreenCaptureAllowed());
        telemetry.setMicrophoneState(telemetryDto.getMicrophoneState());
        telemetry.setIp(telemetryDto.getIp());
        telemetry.setHostname(telemetryDto.getHostname());

        return telemetryRepository.save(telemetry);
    }

    @Override
    public List<TelemetryDtoResponse> getAllTelemetries() {
        List<Telemetry> telemetries = telemetryRepository.findAll();
        List<TelemetryDtoResponse> responses = new ArrayList<>();

        for (Telemetry telemetry : telemetries) {
            TelemetryDtoResponse telemetryDtoResponse = new TelemetryDtoResponse();
            telemetryDtoResponse.setIp(telemetry.getIp());
            telemetryDtoResponse.setDataDate(telemetry.getDataDate());
            telemetryDtoResponse.setHostDiskFree(telemetry.getCpuUsage());
            telemetryDtoResponse.setMicrophoneState(telemetry.getMicrophoneState());
            telemetryDtoResponse.setScreenCaptureAllowed(telemetry.getScreenCaptureAllowed());
            telemetryDtoResponse.setAudioCaptureAllowed(telemetry.getAudioCaptureAllowed());
            telemetryDtoResponse.setHostname(telemetry.getHostname());
            responses.add(telemetryDtoResponse);
        }
        return responses;
    }
}
