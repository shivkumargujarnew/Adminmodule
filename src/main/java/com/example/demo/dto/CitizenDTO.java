package com.example.demo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CitizenDTO {

    private Long id;
    @NotBlank(message = "Name is required")
    @Size(min=2,message="name must be required canty be null")
    private String name;
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private Integer age;
    @NotBlank(message="geneder is required")
    private String gender;
    @Pattern(regexp ="\\d{10}",message="mobile number must be 10 digit")
    private String mobileNumber;
    @Email(message="invalid mail ")
    private String email;
    private String address;
    @NotBlank(message = "City is required")
    private String city;
    private String state;
    private String pincode;
   
    private LocalDate dateOfBirth;

    // Default Constructor
    public CitizenDTO() {
    }

    // Parameterized Constructor
    public CitizenDTO(Long id, String name, Integer age, String gender,
                      String mobileNumber, String email, String address,
                      String city, String state, String pincode,
                      LocalDate dateOfBirth) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // toString()

    @Override
    public String toString() {
        return "CitizenDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}