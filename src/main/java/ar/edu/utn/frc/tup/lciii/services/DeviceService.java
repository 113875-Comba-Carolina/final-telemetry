package ar.edu.utn.frc.tup.lciii.services;

import org.springframework.stereotype.Service;

import ar.edu.utn.frc.tup.lciii.dtos.common.request.DeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;

import java.util.List;

@Service
public interface DeviceService {
    Device getDeviceByName(String name);
    List<Device> getAllDevices();
    Device postDevice(DeviceDto device);
    List<DeviceDto> getDevicesByType(String type);
}
