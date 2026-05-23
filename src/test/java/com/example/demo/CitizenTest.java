package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.CitizenController;
import com.example.demo.dto.CitizenDTO;
import com.example.demo.service.CitizenService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CitizenController.class)
public class CitizenTest {

    @MockBean
    private CitizenService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    CitizenDTO dto = new CitizenDTO(
            1L,
            "John Doe",
            25,
            "Male",
            "9876543210",
            "john.doe@gmail.com",
            "MG Road, Bangalore",
            "Bangalore",
            "Karnataka",
            "560001",
            LocalDate.of(2000, 1, 15)
    );

    CitizenDTO response = new CitizenDTO(
            1L,
            "John Doe",
            25,
            "Male",
            "9876543210",
            "john.doe@gmail.com",
            "MG Road, Bangalore",
            "Bangalore",
            "Karnataka",
            "560001",
            LocalDate.of(2000, 1, 15)
    );

    @Test
    public void saveTest() throws Exception {

        when(service.saveCitizen(Mockito.any(CitizenDTO.class)))
                .thenReturn(response);

        mockMvc.perform(post("/admin/citizen")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void getAllCitizensTest() throws Exception {

        List<CitizenDTO> list = Arrays.asList(dto);

        when(service.getAllCitizens()).thenReturn(list);

        mockMvc.perform(get("/admin/citizen"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(1))
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].name").value("John Doe"));
    }

    // ✔ GET BY ID TEST
    @Test
    public void getCitizenByIdTest() throws Exception {

        when(service.getCitizenById(1L)).thenReturn(dto);

        mockMvc.perform(get("/admin/citizen/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    // ✔ DELETE TEST
    @Test
    public void deleteCitizenTest() throws Exception {

        mockMvc.perform(delete("/admin/citizen/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Resourse Deleted Succesfully"));
    }
}