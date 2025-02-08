package ar.edu.utn.frc.tup.lciii.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frc.tup.lciii.model.Device;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {
    Device findByHostName(String hostName);
}
