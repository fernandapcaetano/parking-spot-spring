package br.fernandapcaetano.car_rental_jwt_security_spring.dto;

public record ParkingSpotDto(
    Integer parkingSpotNumber,
    String responsibleId
) {}
