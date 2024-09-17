package br.fernandapcaetano.car_rental_jwt_security_spring.dto;

import java.util.UUID;

public record CarDto(
    UUID id,
    UUID responsibleId,
    String licensePlateCar,
    String brandCar,
    String modelCar,
    String colorCar
) {}
