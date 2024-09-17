package br.fernandapcaetano.car_rental_jwt_security_spring.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fernandapcaetano.car_rental_jwt_security_spring.dto.ResponsibleDto;
import br.fernandapcaetano.car_rental_jwt_security_spring.service.ResponsibleService;

@RestController
@RequestMapping("/api/v1/responsibles")
public class ResponsibleController {

    private final ResponsibleService responsibleService;

    public ResponsibleController(ResponsibleService responsibleService) {
        this.responsibleService = responsibleService;
    }

    @GetMapping
    public ResponseEntity<?> getAllResponsibles() {
        return ResponseEntity.ok(responsibleService.getAllResponsibles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResponsibleById(@PathVariable UUID id) {
        return ResponseEntity.ok(responsibleService.getResponsibleById(id));
    }

    @PostMapping
    public ResponseEntity<?> createResponsible(@RequestBody ResponsibleDto responsibleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(responsibleService.createResponsible(responsibleDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateResponsible(@PathVariable UUID id, @RequestBody ResponsibleDto responsibleDTO) {
        return ResponseEntity.ok(responsibleService.updateResponsible(id, responsibleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResponsible(@PathVariable UUID id) {
        responsibleService.deleteResponsible(id);
        return ResponseEntity.noContent().build();
    }
}
