package ar.edu.utn.frc.tup.lciii.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Device getDeviceByName(String name) {
        return deviceRepository.findByHostName(name);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device postDevice(DeviceDto device) {
        Device device2 = new Device();
        device2.setCreatedDate(LocalDateTime.now());
        device2.setHostName(device.getHostname());
        device2.setMacAdress(device.getMacAdress());
        device2.setOs(device.getOs());
        device2.setType(device.getType());

        return deviceRepository.save(device2);
    }

    @Override
    public List<DeviceDto> getDevicesByType(String type) {
        List<Device> devices = deviceRepository.findByType(type);
        List<DeviceDto> deviceDtos = new ArrayList<>();
        for (Device device : devices) {
            DeviceDto deviceIdDto = new DeviceDto();
            deviceIdDto.setHostname(device.getHostName());
            deviceIdDto.setMacAdress(device.getMacAdress());
            deviceIdDto.setOs(device.getOs());
            deviceIdDto.setType(device.getType());
            deviceDtos.add(deviceIdDto);
        }
        return deviceDtos;
    }

}
