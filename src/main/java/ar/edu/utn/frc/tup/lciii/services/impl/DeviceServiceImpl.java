package ar.edu.utn.frc.tup.lciii.services.impl;

import org.springframework.stereotype.Service;

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
        return deviceRepository.findByName(name);
    }

}
