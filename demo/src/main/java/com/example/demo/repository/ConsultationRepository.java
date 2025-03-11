package com.example.demo.repository;

import com.example.demo.entities.Consultation;
import com.example.demo.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
