package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CitizenDTO;

public interface CitizenService {

	
	    CitizenDTO saveCitizen(CitizenDTO dto);

	    List<CitizenDTO> getAllCitizens();

	    CitizenDTO getCitizenById(Long id);

	    void deleteCitizen(Long id);
}
