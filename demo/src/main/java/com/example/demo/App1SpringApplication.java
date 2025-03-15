package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.RendezVousRepository;
import com.example.demo.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class App1SpringApplication  {

	public static void main(String[] args) {
		SpringApplication.run(App1SpringApplication.class, args);
	}
@Bean
CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,MedecinRepository medecinRepository , RendezVousRepository rendezVousRepository){
return args -> {
	Stream.of("ali","laila","ahmed").forEach(nom->{
		Patient patient=new Patient();
		patient.setNom(nom);
		patient.setDateNaissance(new Date());
		patient.setScore((int) (Math.random() * 11));;
		patient.setMalade(false);
		hospitalService.savePatient(patient);

	});
	Stream.of("zineb","amine","najat").forEach(nom->{
		Medecin medecin=new Medecin();
		medecin.setNom(nom);
		medecin.setEmail(nom+"@gmail.com");
		medecin.setSpecialite(Math.random()<0.5?"Cardio":"Dentiste");
		hospitalService.saveMedecin(medecin);

	});
	Patient patient=hospitalService.findPtientById(1L);
	Patient patient1=hospitalService.findPtientByName("ali");
	Medecin medecin=hospitalService.findMedByName("najat");
	RendezVous rendezVous=new RendezVous();
	rendezVous.setPatient(patient1);
	rendezVous.setMedecin(medecin);
	rendezVous.setDate(new Date());
	rendezVous.setStatus(StatusRDV.PENDING);
	hospitalService.saveRDV(rendezVous);
	RendezVous rendezVous1=hospitalService.findRDVById(1L);
	Consultation consultation=new Consultation();
	consultation.setDateConsultation(new Date());
	consultation.setRendezVous(rendezVous1);
	consultation.setRapport("rapport de la consultation ");
hospitalService.saveConsultation(consultation);
};
}

}
