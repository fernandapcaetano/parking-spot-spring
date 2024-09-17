package br.fernandapcaetano.car_rental_jwt_security_spring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fernandapcaetano.car_rental_jwt_security_spring.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {}
