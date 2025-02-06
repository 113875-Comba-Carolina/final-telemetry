package ar.edu.utn.frc.tup.lciii.dtos.common.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelemetryDto {
    private String hostname;
    private Double cpuUsage;
    private String ip;
    private Double hostDiskFree;
    private String microphoneState;
    private Boolean screenCaptureAllowed;
    private Boolean audioCaptureAllowed;
    private LocalDateTime dataDate;
}
