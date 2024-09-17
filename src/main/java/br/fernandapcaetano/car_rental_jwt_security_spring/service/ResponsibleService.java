package br.fernandapcaetano.car_rental_jwt_security_spring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.fernandapcaetano.car_rental_jwt_security_spring.dto.ResponsibleDto;
import br.fernandapcaetano.car_rental_jwt_security_spring.model.Responsible;
import br.fernandapcaetano.car_rental_jwt_security_spring.repositories.ResponsibleRepository;

@Service
public class ResponsibleService {

    private final ResponsibleRepository responsibleRepository;

    public ResponsibleService(ResponsibleRepository responsibleRepository) {
        this.responsibleRepository = responsibleRepository;
    }

    public List<ResponsibleDto> getAllResponsibles() {
        return responsibleRepository.findAll().stream()
                .map(resp -> new ResponsibleDto(
                        resp.getId(),
                        resp.getResponsibleName(),
                        resp.getApartment(),
                        resp.getBlock()))
                .toList();
    }

    public ResponsibleDto getResponsibleById(UUID id) {
        return responsibleRepository.findById(id)
                .map(resp -> new ResponsibleDto(
                        resp.getId(),
                        resp.getResponsibleName(),
                        resp.getApartment(),
                        resp.getBlock()))
                .orElseThrow(() -> new RuntimeException("Responsible not found"));
    }

    public ResponsibleDto createResponsible(ResponsibleDto responsibleDTO) {
        var responsible = new Responsible();
        responsible.setId(UUID.randomUUID());
        responsible.setResponsibleName(responsibleDTO.responsibleName());
        responsible.setApartment(responsibleDTO.apartment());
        responsible.setBlock(responsibleDTO.block());

        responsibleRepository.save(responsible);

        return new ResponsibleDto(
                responsible.getId(),
                responsible.getResponsibleName(),
                responsible.getApartment(),
                responsible.getBlock());
    }

    public ResponsibleDto updateResponsible(UUID id, ResponsibleDto responsibleDTO) {
        var responsible = responsibleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Responsible not found"));

        responsible.setResponsibleName(responsibleDTO.responsibleName());
        responsible.setApartment(responsibleDTO.apartment());
        responsible.setBlock(responsibleDTO.block());

        responsibleRepository.save(responsible);

        return new ResponsibleDto(
                responsible.getId(),
                responsible.getResponsibleName(),
                responsible.getApartment(),
                responsible.getBlock());
    }

    public void deleteResponsible(UUID id) {
        responsibleRepository.deleteById(id);
    }
}
