package com.example.demo.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CitizenDTO;
import com.example.demo.entity.Citizen;
import com.example.demo.exceptionInfo.ReSourseNotFoundException;
import com.example.demo.repository.CitizenRepo;
import com.example.demo.service.CitizenService;
@Service
public class CitizenServiceImpl implements CitizenService{
         @Autowired
	     private CitizenRepo citizenRepo;
         @Autowired
          private ModelMapper mapper;
         
	@Override
	public CitizenDTO saveCitizen(CitizenDTO dto) {
		  Citizen entity=mapper.map(dto, Citizen.class);
		   Citizen saved =citizenRepo.save(entity);
		return mapper.map(saved, CitizenDTO.class);
	}

	@Override
	public List<CitizenDTO> getAllCitizens() {	  
		List<Citizen> list=citizenRepo.findAll();
		return  list.stream().map(en->mapper.map(en, CitizenDTO.class)).toList();
	}

	@Override
	public CitizenDTO getCitizenById(Long id) {
		Citizen entity=citizenRepo.findById(id).orElseThrow(()->new ReSourseNotFoundException("Resourse NOt Found Gioven Id:"+ +id));
		  return mapper.map(entity, CitizenDTO.class);
	
	}

	@Override
	public void deleteCitizen(Long id) { 
		Citizen entity=citizenRepo.findById(id).orElseThrow(()->new ReSourseNotFoundException("Resourse NOt Found Gioven Id:"+ +id));
		citizenRepo.delete(entity);
	}

}
