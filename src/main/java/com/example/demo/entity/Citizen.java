package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String gender;

    private String mobileNumber;

    private String email;

    private String address;

    private String city;

    private String state;

    private String pincode;

    private LocalDate dateOfBirth;

    // Default Constructor
    public Citizen() {
    }

    // Parameterized Constructor
    public Citizen(Long id, String name, Integer age, String gender,
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

    // equals()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citizen)) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equals(id, citizen.id)
                && Objects.equals(mobileNumber, citizen.mobileNumber);
    }

    // hashCode()

    @Override
    public int hashCode() {
        return Objects.hash(id, mobileNumber);
    }

    // toString()

    @Override
    public String toString() {
        return "Citizen{" +
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