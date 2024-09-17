package br.fernandapcaetano.car_rental_jwt_security_spring.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ParkingSpot implements Serializable{

    @Id
    private Integer parkingSpotNumber;

    @OneToOne
    @JoinColumn(name = "responsible_id", nullable = false)
    private Responsible responsible;

}
