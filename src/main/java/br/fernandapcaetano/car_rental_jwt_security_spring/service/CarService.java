package br.fernandapcaetano.car_rental_jwt_security_spring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.fernandapcaetano.car_rental_jwt_security_spring.dto.CarDto;
import br.fernandapcaetano.car_rental_jwt_security_spring.model.Car;
import br.fernandapcaetano.car_rental_jwt_security_spring.repositories.CarRepository;
import br.fernandapcaetano.car_rental_jwt_security_spring.repositories.ResponsibleRepository;

@Service
public class CarService {
    
    private final CarRepository carRepository;
    private final ResponsibleRepository responsibleRepository;

    public CarService(CarRepository carRepository, ResponsibleRepository responsibleRepository) {
        this.carRepository = carRepository;
        this.responsibleRepository = responsibleRepository;
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(car -> new CarDto(
                        car.getId(),
                        car.getResponsible().getId(),
                        car.getLicensePlateCar(),
                        car.getBrandCar(),
                        car.getModelCar(),
                        car.getColorCar()))
                .toList();
    }

    public CarDto getCarById(UUID id) {
        return carRepository.findById(id)
                .map(car -> new CarDto(
                        car.getId(),
                        car.getResponsible().getId(),
                        car.getLicensePlateCar(),
                        car.getBrandCar(),
                        car.getModelCar(),
                        car.getColorCar()))
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public CarDto createCar(CarDto carDTO) {
        var responsible = responsibleRepository.findById(carDTO.responsibleId())
                .orElseThrow(() -> new RuntimeException("Responsible not found"));

        var car = new Car();
        car.setId(UUID.randomUUID());
        car.setResponsible(responsible);
        car.setLicensePlateCar(carDTO.licensePlateCar());
        car.setBrandCar(carDTO.brandCar());
        car.setModelCar(carDTO.modelCar());
        car.setColorCar(carDTO.colorCar());

        carRepository.save(car);

        return new CarDto(
                car.getId(),
                car.getResponsible().getId(),
                car.getLicensePlateCar(),
                car.getBrandCar(),
                car.getModelCar(),
                car.getColorCar());
    }

    public CarDto updateCar(UUID id, CarDto carDTO) {
        var car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        var responsible = responsibleRepository.findById(carDTO.responsibleId())
                .orElseThrow(() -> new RuntimeException("Responsible not found"));

        car.setResponsible(responsible);
        car.setLicensePlateCar(carDTO.licensePlateCar());
        car.setBrandCar(carDTO.brandCar());
        car.setModelCar(carDTO.modelCar());
        car.setColorCar(carDTO.colorCar());

        carRepository.save(car);

        return new CarDto(
                car.getId(),
                car.getResponsible().getId(),
                car.getLicensePlateCar(),
                car.getBrandCar(),
                car.getModelCar(),
                car.getColorCar());
    }

    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }
}
