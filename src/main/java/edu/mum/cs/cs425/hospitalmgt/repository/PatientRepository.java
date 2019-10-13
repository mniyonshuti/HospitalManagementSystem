package edu.mum.cs.cs425.hospitalmgt.repository;

import edu.mum.cs.cs425.hospitalmgt.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    public Iterable<Patient> getAllByPatientNumberIsContainingOrderByFullNames(String s);
    public Iterable<Patient> getAllByDateOfBirthBeforeOrderByDateOfBirthDesc(LocalDate s);
    public Iterable<Patient> getAllByContactPhoneNumberContainsOrFullNamesContainsOrEmailAddressContainsOrIsAnOutPatientContainsOrContactPhoneNumberContainsOrderByFullNames
            (String s,String s1,String s2,String s3,String s4);
}
