package br.fernandapcaetano.car_rental_jwt_security_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fernandapcaetano.car_rental_jwt_security_spring.dto.ParkingSpotDto;
import br.fernandapcaetano.car_rental_jwt_security_spring.service.ParkingSpotService;

@RestController
@RequestMapping("/api/v1/parking-spots")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getParkingSpotByNumber(@PathVariable Integer number) {
        return ResponseEntity.ok(parkingSpotService.getParkingSpotByNumber(number));
    }

    @PostMapping
    public ResponseEntity<?> createParkingSpot(@RequestBody ParkingSpotDto parkingSpotDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.createParkingSpot(parkingSpotDTO));
    }
}
