package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Long>{

}
