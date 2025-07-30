package com.trazoft.Bascula.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trazoft.Bascula.dto.WeigthMachineDTO;
import com.trazoft.Bascula.models.Parity;
import com.trazoft.Bascula.models.ResponseObject;
import com.trazoft.Bascula.models.WeightMachine;
import com.trazoft.Bascula.repositories.ParityBitRepository;
import com.trazoft.Bascula.repositories.WeightMachineRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/api/WeightMachine")
public class WeightMachineController {
    @Autowired
    private WeightMachineRepository repository;
    @Autowired
    private ParityBitRepository parityTypesRepository;
 
    @GetMapping("/")
    private ResponseEntity<ResponseObject> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "", repository.findAll())  
        );
    }

    @PostMapping("/add")
    private ResponseEntity<ResponseObject> add(@Valid @RequestBody WeigthMachineDTO weigthMachineToAdd ) {
        // Looks for existing valid parity
        Optional<Parity> parity = parityTypesRepository.findById(weigthMachineToAdd.getParityId());
        if(parity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(false, "parity_invalid_error", "")
            );
        }

        WeightMachine weightMachine = new WeightMachine(
            weigthMachineToAdd.getName(),
            weigthMachineToAdd.getDescription(),
            weigthMachineToAdd.getPort(),
            weigthMachineToAdd.getBaudRate(),
            weigthMachineToAdd.getStopBits(),
            parity.get(),
            weigthMachineToAdd.isFlippedText(),
            weigthMachineToAdd.getIpAddress(),
            LocalDateTime.now(),
            LocalDateTime.now(),
            true
        );

        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "", repository.save(weightMachine))
        );
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<ResponseObject> add(@PathVariable Long id, @Valid @RequestBody WeigthMachineDTO weigthMachineToAdd ) {
        // Checks for a valid parity
        Optional<Parity> parity = parityTypesRepository.findById(weigthMachineToAdd.getParityId());
        if(parity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(false, "parity_invalid_error", "")
            );
        }

        // Updates weight machine
        Optional<WeightMachine> updatedWeightMachine = repository.findById(id).map( weightMachine -> {
            weightMachine.setName(weigthMachineToAdd.getName());
            weightMachine.setDescription(weigthMachineToAdd.getDescription());
            weightMachine.setPort(weigthMachineToAdd.getPort());
            weightMachine.setBaudRate(weigthMachineToAdd.getBaudRate());
            weightMachine.setBaudRate(weigthMachineToAdd.getStopBits());
            weightMachine.setParity(parity.get());
            weightMachine.setFlippedText(weigthMachineToAdd.isFlippedText());
            weightMachine.setIpAddress(weigthMachineToAdd.getIpAddress());
            weightMachine.setLastUpdateDate(LocalDateTime.now());
            return repository.save(weightMachine);
        });

        if(updatedWeightMachine.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(false, "weight_machine_not_found_error", updatedWeightMachine)
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "", updatedWeightMachine)
        );
    }

    @PutMapping("/changeStatus/{id}")
    private ResponseEntity<ResponseObject> chageStatus(@PathVariable Long id){
        // Updates weight machine availability
        Optional<WeightMachine> updatedWeightMachine = repository.findById(id).map( weightMachine -> {
            weightMachine.setAvailable(!weightMachine.isAvailable());
            weightMachine.setLastUpdateDate(LocalDateTime.now());
            return repository.save(weightMachine);
        });
        
        if(updatedWeightMachine.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(false, "weight_machine_not_found", updatedWeightMachine)
            );
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "", updatedWeightMachine)
        );
    }
}
