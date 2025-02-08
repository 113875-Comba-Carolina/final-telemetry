package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.repositories.DeviceRepository;
import ar.edu.utn.frc.tup.lciii.services.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeviceServiceImplTest {

    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceServiceImpl deviceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getDeviceByNameTest_HappyPath() {
        Device expected = new Device("test", null, LocalDateTime.now(), "Windows", "sdfsdf", "sdfdsf");
        String name = "test";
        when(deviceRepository.findByHostName(name)).thenReturn(expected);

        // Act
        Device result = deviceService.getDeviceByName(name);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void getAllDevicesTest_HappyPath() {
        List<Device> expected = Arrays.asList(
                new Device("cc", null, LocalDateTime.now(), "w", "sdfsd", "asdfasd"),
                new Device("cc", null, LocalDateTime.now(), "w", "sdfsd", "asdfasd")
        );
        when(deviceRepository.findAll()).thenReturn(expected);
        List<Device> result = deviceService.getAllDevices();
        assertEquals(expected, result);

    }

    @Test
    void postDeviceTest_HappyPath() {
    }

    @Test
    void getDevicesByTypeTest_HappyPath() {
    }
}