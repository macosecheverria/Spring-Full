package com.andres.curso.springboot.relacionesjpa.relacionesjpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.andres.curso.springboot.relacionesjpa.relacionesjpa.entities.Address;
import com.andres.curso.springboot.relacionesjpa.relacionesjpa.entities.Client;
import com.andres.curso.springboot.relacionesjpa.relacionesjpa.entities.Invoice;
import com.andres.curso.springboot.relacionesjpa.relacionesjpa.repositories.ClientRepository;
import com.andres.curso.springboot.relacionesjpa.relacionesjpa.repositories.InvoiceRepository;


@SpringBootApplication
public class RelacionesJpaApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository InvoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(RelacionesJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// manyToOneCreate();
		// manyToOneScannerCreate();
		// manyToOneFindByIdClient();
		// oneToManyCreate();
		// oneToManyFindById();
		removeAddress();
	}

	@Transactional()
	public void manyToOneCreate() {

		Client client = new Client("John", "Doe");
		this.clientRepository.save(client);

		Invoice invoice = new Invoice("Compras de oficinas", 2000L);

		invoice.setClient(client);

		Invoice invoiceDb = this.InvoiceRepository.save(invoice);
		System.out.println(invoiceDb);
	}

	@Transactional()
	public void manyToOneCreateScanner(){
		Scanner scanner =  new Scanner(System.in);
		System.out.print("Enter the client name: ");
		String clientName  = scanner.nextLine();
		System.out.print("Enter the client lastname: ");
		String clientLastname  = scanner.nextLine();

		Client client = new Client(clientName, clientLastname);
		this.clientRepository.save(client);
		
		System.out.print("Enter the invoice description: ");
		String invoiceDescription =  scanner.nextLine();
		
		System.out.print("Enter the invoice total: ");
		Long invoiceTotal = scanner.nextLong();

		Invoice invoice = new Invoice(invoiceDescription, invoiceTotal);
		invoice.setClient(client);
		Invoice invoiceDb = this.InvoiceRepository.save(invoice);

		System.out.println("Invoice: " + invoiceDb);

		scanner.close();
	}

	@Transactional()
	public void manyToOneFindByIdClient(){
		Optional<Client> existClient  = this.clientRepository.findById(1l);

		existClient.ifPresentOrElse(client -> {
			Invoice invoice  = new Invoice("Buys the oficces", 500L);
			invoice.setClient(client);
			Invoice invoiceDb = this.InvoiceRepository.save(invoice);
			System.out.println(invoiceDb);

		}, () -> System.out.println("Internal Server Error"));
	}

	@Transactional
	public void oneToManyCreate(){
		Client client = new Client("Juana" , "De Ramirez");

		Address address1 = new Address("Yataity", 403 );
		Address address2 = new Address("Los lagos", 403);
		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		Client clientDb = this.clientRepository.save(client);
		System.out.println(clientDb);
	}

	@Transactional
	public void oneToManyFindById(){
		Optional<Client> existClient = this.clientRepository.findById(1L);

		existClient.ifPresentOrElse(client -> {
			Address address1 = new Address("La villa", 304);
			Address address2 = new Address("Mora cue", 304);
			client.setAddresses(List.of(address1,address2));

			Client clientDb = this.clientRepository.save(client);
			System.out.println("Client updated" + clientDb);
			
		}, () -> System.out.println("User not found"));
	}

	@Transactional
	public void removeAddress(){
		Client newClient = new Client("Fran", "Moras");

		Address address1 = new Address("Cañaberal", 403);
		Address address2 = new Address("Los lagos", 403);
		
		newClient.setAddresses(List.of(address1, address2));

		Optional<Client> existClient = this.clientRepository.findById(3L);

		existClient.ifPresentOrElse(client -> {
			client.getAddresses().remove(address1);
			this.clientRepository.save(client);
			System.out.println(client);

		}, () -> System.out.println("Internal Server Error"));
	}

}
