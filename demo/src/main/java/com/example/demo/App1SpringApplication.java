package com.example.demo;

import com.example.demo.entities.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class App1SpringApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(App1SpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
patientRepository.save(new Patient(null,"ali",new Date(),true,11));
		patientRepository.save(new Patient(null,"amine",new Date(),false,2));
		patientRepository.save(new Patient(null,"laila",new Date(),false,18));
		patientRepository.findAll().forEach(ps->{
			System.out.println(ps.getId());
			System.out.println(ps.getNom());
			System.out.println(ps.getDateNaissance());
			System.out.println(ps.getScore());
		});
		System.out.println("**********");
		System.out.println("Consulter un  "+patientRepository.findById(Long.valueOf(2)).get());
		System.out.println("**********");
		System.out.println("Chercher des patients avec nom contient: al ");
		patientRepository.findByNomContainsIgnoreCase("al").forEach(p -> {
			System.out.println(p.getId());
			System.out.println(p.getNom());
			System.out.println(p.getScore());
			System.out.println("**************");
		});
		// Update a patient
		Patient patient = patientRepository.findById(Long.valueOf(2)).get();
		if (patient != null) {
			patient.setScore(10);
			patientRepository.save(patient);
			System.out.println("Updated le score de patient: " + patient.getNom());
		}
		// Delete a patient
		patientRepository.deleteById(Long.valueOf(3));
		System.out.println("Deleted patient with ID 3");
	}
}
