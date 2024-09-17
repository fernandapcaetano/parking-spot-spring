package br.fernandapcaetano.car_rental_jwt_security_spring.dto;

import java.util.UUID;

public record ResponsibleDto(
    UUID id,
    String responsibleName,
    String apartment,
    String block
) {}
