package ar.edu.utn.frc.tup.lciii.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import ar.edu.utn.frc.tup.lciii.dtos.common.request.DeviceDto;
import ar.edu.utn.frc.tup.lciii.services.DeviceService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @PostMapping("/device")
    public ResponseEntity<?> postMethodName(@RequestBody DeviceDto entity) {
        return new ResponseEntity<>(deviceService.postDevice(entity), HttpStatus.CREATED);
    }

    @GetMapping("/device")
    public ResponseEntity<?> getDevicesByType(@RequestParam("type") String type) {
        return new ResponseEntity<>(deviceService.getDevicesByType(type), HttpStatus.OK);
    }
    
}