package ar.edu.utn.frc.tup.lciii.dtos.common.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
    private String hostName;
    private String os;
    private String macAdress;
    private String type;
}
