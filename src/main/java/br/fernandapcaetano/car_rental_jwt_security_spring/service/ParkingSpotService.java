package br.fernandapcaetano.car_rental_jwt_security_spring.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.fernandapcaetano.car_rental_jwt_security_spring.dto.ParkingSpotDto;
import br.fernandapcaetano.car_rental_jwt_security_spring.model.ParkingSpot;
import br.fernandapcaetano.car_rental_jwt_security_spring.repositories.ParkingSpotRepository;
import br.fernandapcaetano.car_rental_jwt_security_spring.repositories.ResponsibleRepository;

@Service
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;
    private final ResponsibleRepository responsibleRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository, ResponsibleRepository responsibleRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.responsibleRepository = responsibleRepository;
    }

    public ParkingSpotDto getParkingSpotByNumber(Integer number) {
        ParkingSpot parkingSpot = parkingSpotRepository.findById(number)
                .orElseThrow(() -> new RuntimeException("Parking Spot not found"));
    
        return new ParkingSpotDto(
                parkingSpot.getParkingSpotNumber(),
                parkingSpot.getResponsible().getId().toString()
        );
    }

    public ParkingSpotDto createParkingSpot(ParkingSpotDto parkingSpotDTO) {
        var responsible = responsibleRepository.findById(UUID.fromString(parkingSpotDTO.responsibleId()))
                .orElseThrow(() -> new RuntimeException("Responsible not found"));

        var spot = new ParkingSpot();
        spot.setParkingSpotNumber(parkingSpotDTO.parkingSpotNumber());
        spot.setResponsible(responsible);

        parkingSpotRepository.save(spot);

        return new ParkingSpotDto(
                spot.getParkingSpotNumber(),
                spot.getResponsible().getId().toString());
    }
}
