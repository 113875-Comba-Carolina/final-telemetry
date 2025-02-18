package ar.edu.utn.frc.tup.lciii.dtos.common.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelemetryDto {
    private String hostName;
    private String ip;
    private Double hostDiskFree;
    private String microphoneState;
    private Boolean screenCaptureAllowed;
    private Boolean audioCaptureAllowed;
}
