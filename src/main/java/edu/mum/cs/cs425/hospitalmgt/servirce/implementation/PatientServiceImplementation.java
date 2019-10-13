package edu.mum.cs.cs425.hospitalmgt.servirce.implementation;

import edu.mum.cs.cs425.hospitalmgt.model.Patient;
import edu.mum.cs.cs425.hospitalmgt.repository.PatientRepository;
import edu.mum.cs.cs425.hospitalmgt.servirce.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class PatientServiceImplementation implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient savePatient(Patient s) {
        return patientRepository.save(s);
    }

    @Override
    public Iterable<Patient> listPatients() {
        return patientRepository.findAll(Sort.by("fullNames"));
    }

    @Override
    public Iterable<Patient> patientGrt65() {
        return patientRepository.getAllByDateOfBirthBeforeOrderByDateOfBirthDesc(birthDateGrtThan65());
    }

    @Override
    public Iterable<Patient> searchPatient(String s, String s1, String s2, String s3, String s4) {
        return patientRepository.getAllByContactPhoneNumberContainsOrFullNamesContainsOrEmailAddressContainsOrIsAnOutPatientContainsOrContactPhoneNumberContainsOrderByFullNames(s,s1,s2,s3,s4);
    }

    public static LocalDate birthDateGrtThan65() {
        LocalDate today = LocalDate.now();
        int year = today.getYear() - 65;
        return LocalDate.of(year, today.getMonthValue(), today.getDayOfMonth());
    }

}
