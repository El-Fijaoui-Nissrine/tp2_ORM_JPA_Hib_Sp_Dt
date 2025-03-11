package com.example.demo.repository;

import com.example.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
public List<Patient> findByNomContainsIgnoreCase(String nom);
public Patient findByNom(String nom);
}
