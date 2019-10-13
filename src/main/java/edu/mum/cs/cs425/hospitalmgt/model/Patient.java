package edu.mum.cs.cs425.hospitalmgt.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String patientNumber;
    private String isAnOutPatient;
    private String fullNames;
    private String emailAddress;
    private String contactPhoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Patient() {
    }

    public Patient(String patientNumber, String isAnOutPatient, String fullNames, String emailAddress, String contactPhoneNumber, LocalDate dateOfBirth) {
        this.patientNumber = patientNumber;
        this.isAnOutPatient = isAnOutPatient;
        this.fullNames = fullNames;
        this.emailAddress = emailAddress;
        this.contactPhoneNumber = contactPhoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getIsAnOutPatient() {
        return isAnOutPatient;
    }

    public void setIsAnOutPatient(String isAnOutPatient) {
        this.isAnOutPatient = isAnOutPatient;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientNumber='" + patientNumber + '\'' +
                ", isAnOutPatient='" + isAnOutPatient + '\'' +
                ", fullNames='" + fullNames + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
