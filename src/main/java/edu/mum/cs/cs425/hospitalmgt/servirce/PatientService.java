package edu.mum.cs.cs425.hospitalmgt.servirce;

import edu.mum.cs.cs425.hospitalmgt.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface PatientService {
    public Patient savePatient(Patient s);

    public Iterable<Patient> listPatients();

    public Iterable<Patient> patientGrt65();

    public Iterable<Patient> searchPatient(String s,String s1,String s2,String s3,String s4);
}
