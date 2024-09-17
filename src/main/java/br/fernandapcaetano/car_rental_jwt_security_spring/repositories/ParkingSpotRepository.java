package br.fernandapcaetano.car_rental_jwt_security_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fernandapcaetano.car_rental_jwt_security_spring.model.ParkingSpot;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {}
