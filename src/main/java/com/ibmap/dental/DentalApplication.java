package com.ibmap.dental;

import com.ibmap.dental.domaine.entities.Members;
import com.ibmap.dental.repositories.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DentalApplication implements CommandLineRunner {
	@Autowired
	private MembersRepository membersRepository;
	public static void main(String[] args) {
		SpringApplication.run(DentalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Members pereDeFamille = new Members("BALDE","Ibrahima");
		System.out.println("\n question for pereDeFamille");
		askQuestion(pereDeFamille);

		Members femme = new Members("DIALLO","Fatoumata Binta");

		Members fille = new Members("BALDE","Sira");


		Members garcon = new Members("BALDE","Sammba");

		pereDeFamille.add(femme);
		pereDeFamille.add(fille);
		pereDeFamille.add(garcon);


		System.out.println("\n question for fille");
		askQuestion(fille);

		System.out.println("\n question for pereDeFamille");
		askQuestion(pereDeFamille);

		membersRepository.save(pereDeFamille);

		Members pereDeFamille2 = new Members("SOW","Alfa");
		Members femme2 = new Members("BARRY","Mariama");

		Members fille1 = new Members("BARRY","Aminata");
		Members fille2 = new Members("BARRY","Fatoumata");


		Members garcon1 = new Members("BARRY","Alfa");
		Members garcon2 = new Members("BARRY","Oumar");
		Members garcon3 = new Members("BARRY","Wuuri");

		pereDeFamille2.add(Arrays.asList(fille1, fille2, garcon1, garcon2, garcon3));

		membersRepository.save(pereDeFamille2);
	}

	private void askQuestion(Members member) {
		System.out.println("isRoot "+member.isRoot());
		System.out.println("isAlone "+member.isAlone());
		System.out.println("isDependent "+member.isDependent());
		System.out.println("isHouseholder "+member.isHouseholder());
		System.out.println("-------------------------------------");
		System.out.println("- "+ member);
		System.out.println("-------------------------------------");
		System.out.println("@@@@@@@@");
		member.showChild();
		System.out.println("@@@@@@@@");
	}
}
