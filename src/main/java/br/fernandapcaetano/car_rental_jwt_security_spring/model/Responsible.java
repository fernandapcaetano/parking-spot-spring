package br.fernandapcaetano.car_rental_jwt_security_spring.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Responsible implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @OneToMany(mappedBy = "responsible")
    private List<Car> cars;

    @OneToOne(mappedBy = "responsible")
    private ParkingSpot parkingSpot;

    @Column(nullable = false, length = 130)
    private String responsibleName;

    @Column(nullable = false, length = 30)
    private String apartment;

    @Column(nullable = false, length = 30)
    private String block;

}
