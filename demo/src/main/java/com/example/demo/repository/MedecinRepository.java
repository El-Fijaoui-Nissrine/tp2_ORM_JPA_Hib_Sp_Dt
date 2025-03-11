package com.example.demo.repository;

import com.example.demo.entities.Medecin;
import com.example.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
 public Medecin findByNom(String nom);
}
