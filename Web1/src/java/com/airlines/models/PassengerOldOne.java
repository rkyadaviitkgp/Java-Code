/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlines.models;

import java.util.Date;

/**
 *
 * @author rajeshkumar.yadav
 */
public class PassengerOldOne {
    
    private String firstName;
    private String lastName;
    private Date dob;
    private Gender gender;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passenger{" + "firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender + '}';
    }
    
    
}
