package ar.edu.utn.frc.tup.lciii.services.impl;

import java.time.LocalDateTime;

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
    public Device postDevice(DeviceDto device) {
        Device device2 = new Device();
        device2.setCreatedDate(LocalDateTime.now());
        device2.setHostName(device.getHostname());
        device2.setMacAdress(device.getMacAdress());
        device2.setOs(device.getOs());
        device2.setType(device.getType());

        return deviceRepository.save(device2);
    }

}
