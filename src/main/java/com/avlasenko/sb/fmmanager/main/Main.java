package com.avlasenko.sb.fmmanager.main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.avlasenko.sb.fmmanager.Account;
import com.avlasenko.sb.fmmanager.Address;
import com.avlasenko.sb.fmmanager.Client;
import com.avlasenko.sb.fmmanager.Contact;
import com.avlasenko.sb.fmmanager.Document;
import com.avlasenko.sb.fmmanager.Employee;
import com.avlasenko.sb.fmmanager.FmProfile;
import com.avlasenko.sb.fmmanager.Person;
import com.avlasenko.sb.fmmanager.Related;
import com.avlasenko.sb.fmmanager.Risk;
import com.avlasenko.sb.fmmanager.Work;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("test_unit");
		EntityManager entityManager = emfactory.createEntityManager();

		entityManager.getTransaction().begin();

		Address a1 = new Address();
		a1.setId(0);
		a1.setCity("Kiev");

		Address a2 = new Address();
		a2.setId(1);
		a2.setCity("Cherkassy");

		entityManager.persist(a1);
		entityManager.persist(a2);

		Document d1 = new Document();
		d1.setName("Passport");
		d1.setId(0);
		d1.setAuthority("Some authority");

		entityManager.persist(d1);

		Work w1 = new Work();
		w1.setId(0);
		w1.setName("Main Work");

		entityManager.persist(w1);

		Contact contact1 = new Contact();
		contact1.setEmail("some@email.com");
		contact1.setMobileTel("+38 063 111 11 11");

		Person employee1 = new Employee();
		((Employee) employee1).setId(0);
		employee1.setFirstName("Employee");

		entityManager.persist(employee1);

		Person related1 = new Related();
		((Related) related1).setId(0);
		related1.setFirstName("Related");

		entityManager.persist(related1);

		Account account1 = new Account();
		account1.setId(1);
		account1.setBalance(300000);
		account1.setNumber(2630);

		Account account2 = new Account();
		account2.setId(2);
		account2.setBalance(250000);
		account2.setNumber(2620);

		Person c1 = new Client();
		((Client) c1).setId(0);
		c1.setCitizenship(840);
		c1.setDateBirth(LocalDate.of(1989, 6, 1));
		c1.setFirstName("Anton");
		c1.setIdentNumber(326598562);
		c1.setLastName("Vlasenko");
		c1.setPlaceBirth("Cherkassy");
		c1.setAddress(a1);
		c1.setDocument(d1);
		c1.setWork(w1);
		((Client) c1).setServices(Arrays.asList("Deposit", "Current account"));
		((Client) c1).setContact(contact1);
		((Client) c1).setEmployee((Employee) employee1);
		((Client) c1).setRelateds(Arrays.asList((Related) related1));
		((Client) c1).addAccount(account1);
		((Client) c1).addAccount(account2);

		Person c2 = new Client();
		((Client) c2).setId(1);
		c2.setCitizenship(840);
		c2.setDateBirth(LocalDate.of(1990, 5, 9));
		c2.setFirstName("Julia");
		c2.setIdentNumber(548455);
		c2.setLastName("Vlasenko");
		c2.setPlaceBirth("Cherkassy");
		c2.setAddress(a2);

		entityManager.persist(account1);
		entityManager.persist(account2);


		entityManager.persist(c1);
		entityManager.persist(c2);
		
		FmProfile fmprofile1 = new FmProfile();
		fmprofile1.setId(0);		
		fmprofile1.addRisk(Risk.LOW);
		
		entityManager.persist(fmprofile1);

		entityManager.getTransaction().commit();

		
		

		entityManager.close();
		emfactory.close();

	}

}
