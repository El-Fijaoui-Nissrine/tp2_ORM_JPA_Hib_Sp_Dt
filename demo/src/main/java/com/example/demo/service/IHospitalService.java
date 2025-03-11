package com.example.demo.service;

import com.example.demo.entities.Consultation;
import com.example.demo.entities.Medecin;
import com.example.demo.entities.Patient;
import com.example.demo.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient (Patient patient);
    Medecin saveMedecin (Medecin medecin);
    RendezVous saveRDV (RendezVous rendezVous);
    Consultation saveConsultation (Consultation consultation);
}
