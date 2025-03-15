package com.example.demo.service;

import com.example.demo.entities.Consultation;
import com.example.demo.entities.Medecin;
import com.example.demo.entities.Patient;
import com.example.demo.entities.RendezVous;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService{
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        //rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient findPtientById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient findPtientByName(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public Medecin findMedByName(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public RendezVous findRDVById(Long id) {
        return rendezVousRepository.findById(id).get();
    }


}
