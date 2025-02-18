package ar.edu.utn.frc.tup.lciii.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frc.tup.lciii.dtos.common.response.DeviceIdDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ar.edu.utn.frc.tup.lciii.dtos.common.request.DeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.repositories.DeviceRepository;
import ar.edu.utn.frc.tup.lciii.services.DeviceService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Device getDeviceByHostName(String name) {
        return deviceRepository.findByHostName(name);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device postDevice(DeviceDto deviceDto) {
        Device device = objectMapper.convertValue(deviceDto, Device.class);
        device.setCreatedDate(LocalDateTime.now());

        return deviceRepository.save(device);
    }

    @Override
    public List<DeviceDto> getDevicesByType(String type) {
        List<Device> devices = deviceRepository.findAll();
        List<DeviceDto> deviceDtos = new ArrayList<>();
        for (Device device : devices) {
            if (device.getType().equals(type)) {
                DeviceDto deviceDto = new DeviceDto();
                deviceDto.setHostName(device.getHostName());
                deviceDto.setOs(device.getOs());
                deviceDto.setMacAdress(device.getMacAdress());
                deviceDto.setType(device.getType());
                deviceDtos.add(deviceDto);
            }
        }
        return deviceDtos;
    }
}
