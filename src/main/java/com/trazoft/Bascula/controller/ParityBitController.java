package com.trazoft.Bascula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trazoft.Bascula.models.ResponseObject;
import com.trazoft.Bascula.repositories.ParityBitRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path="/api/ParityBit")
public class ParityBitController {
    @Autowired
    private ParityBitRepository repository;

    @GetMapping("/")
    private ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "", repository.findAll())
        );
    }
}
