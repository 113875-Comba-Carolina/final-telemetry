package ar.edu.utn.frc.tup.lciii.services;

import org.springframework.stereotype.Service;

import ar.edu.utn.frc.tup.lciii.dtos.common.request.DeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;

@Service
public interface DeviceService {
    Device getDeviceByName(String name);
    Device postDevice(DeviceDto device);
}
