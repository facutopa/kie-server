package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Patient {
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("firstName")
    private String firstName;
    
    @JsonProperty("lastName")
    private String lastName;
    
    @JsonProperty("dni")
    private String dni;
    
    @JsonProperty("age")
    private int age;
    
    @JsonProperty("gender")
    private String gender;
    
    @JsonProperty("familyHistory")
    private boolean familyHistory;
    
    @JsonProperty("medications")
    private List<String> medications;
    
    @JsonProperty("alcoholConsumption")
    private boolean alcoholConsumption;
    
    @JsonProperty("fastingStatus")
    private boolean fastingStatus;

    // Constructores
    public Patient() {}

    public Patient(String id, String firstName, String lastName, String dni, int age, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.age = age;
        this.gender = gender;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(boolean familyHistory) {
        this.familyHistory = familyHistory;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public boolean isAlcoholConsumption() {
        return alcoholConsumption;
    }

    public void setAlcoholConsumption(boolean alcoholConsumption) {
        this.alcoholConsumption = alcoholConsumption;
    }

    public boolean isFastingStatus() {
        return fastingStatus;
    }

    public void setFastingStatus(boolean fastingStatus) {
        this.fastingStatus = fastingStatus;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", familyHistory=" + familyHistory +
                ", medications=" + medications +
                ", alcoholConsumption=" + alcoholConsumption +
                ", fastingStatus=" + fastingStatus +
                '}';
    }
}
