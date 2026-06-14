package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.dto.CitizenDTO;
import com.example.demo.service.CitizenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/citizen")
public class CitizenController {
       //hi
       //by
         @Autowired
	  private  CitizenService service;
      @PostMapping
      public ResponseEntity<CitizenDTO> saveCitizen(@RequestBody @Valid CitizenDTO dto) {
          return new ResponseEntity<>(service.saveCitizen(dto), HttpStatus.CREATED);
      }
      @GetMapping
      ResponseEntity<List<CitizenDTO>> getAllCitizens(){
    	return new ResponseEntity<>(service.getAllCitizens(), HttpStatus.OK);
    }
     @GetMapping("/{id}")
     ResponseEntity<CitizenDTO> getCitizenById(@PathVariable("id") Long id) {
    	return new ResponseEntity<>(service.getCitizenById(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCitizen(@PathVariable("id") Long id) {
    	return new ResponseEntity<String>("Resourse Deleted Succesfully", HttpStatus.OK);
    }
    
}
