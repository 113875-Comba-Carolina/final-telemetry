package ar.edu.utn.frc.tup.lciii.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "DEVICE")
public class Device {

    @Id
    @Column(name = "HOSTNAME", unique = true)
    private String hostName;

    @OneToOne(mappedBy = "device")
    private Telemetry telemetry;

    private LocalDateTime createdDate;

    private String os;

    private String macAdress;

    private String type;

//    @Column(name = "TYPE")
//    @Enumerated(EnumType.STRING)
//    private DeviceType type;

}
