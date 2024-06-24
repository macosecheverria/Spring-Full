package com.andres.curso.springboot.datajpa.springbootdatajpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.andres.curso.springboot.datajpa.springbootdatajpa.dtos.PersonDto;
import com.andres.curso.springboot.datajpa.springbootdatajpa.entities.Person;
import com.andres.curso.springboot.datajpa.springbootdatajpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootDatajpaApplication implements CommandLineRunner {

	// @Autowired
	private PersonRepository repository;

	public SpringbootDatajpaApplication(PersonRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDatajpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// list();
		// findOne();
		create();
		// update();
		// remove();
		// remove2();
		// methodReturnStringFromPerson();
		// methodReturnNameById();
		// methodReturnLastnameById();
		// methodReturnProgrammingLanguage();
		// methodReturnIdByName();
		// methodReturnFullNameById();
		// personalizeQuery();
		// personalizeQuery2();
		// personalizeQueryDistinct();
		// personalizedQueriesConcatUpperAndLowerCase();
		// personalizedQueriesBetween();
		// personalizedQueriesBetweenScanner();
		// customQueriesPerson();
		// customQueriesPersonReturnFunctionAggregation();
		// subQueries();
		// whereIn();
	}

	@Transactional(readOnly = true)
	public void list() {
		List<Person> persons = (List<Person>) repository.findAll();
		persons.stream().forEach(System.out::println);

		// List<Person> language = repository.findByProgrammingLanguage("typescript");

		// language.stream().forEach(System.out::println);

		List<Person> personsTotal = repository.findAllPerson();
		personsTotal.stream().forEach(System.out::println);

		List<Person> programmingAndName = repository.findByProgrammingLanguageAndName("Java", "Marcos");
		programmingAndName.stream().forEach(System.out::println);

		List<Object[]> personData = repository.obtainPersonData("Marquinho", "Typescript");

		personData.stream().forEach(person -> {
			System.out.println("Nombre: " + person[0] + " y su respectivo lenguaje de programacion: " + person[1]);
		});

		List<Object[]> personOnlyData = repository.obtainPersonData();
		personOnlyData.stream().forEach(person -> {
			System.out.println(person[0] + " es experto en " + person[1]);
		});

		List<Person> personDataProgrammingLanguage = repository.obtainPersonDataByProgrammingLanguage("Typescript");
		personDataProgrammingLanguage.stream().forEach(System.out::println);

		List<Person> personDataName = repository.obtainPersonDataByName("Marcos");

		personDataName.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne() {

		// metodos que traen por defecto jpa

		repository.findById(1L).ifPresent(System.out::println);

		repository.findByName("Antonio").ifPresent(System.out::println);

		repository.findByLastname("Eche").ifPresent(System.out::println);

		repository.findByProgrammingLanguage("Typescript").ifPresent(System.out::println);

		// metodos implementados de forma manual para Jpa
		repository.findOneByName("Marcos").ifPresent(System.out::println);

		repository.findOneLikeName("Marco").ifPresent(System.out::println);

		repository.findOneByLastname("Ramirez").ifPresent(System.out::println);

		repository.findOneByProgrammingLanguage("Csharp").ifPresent(System.out::println);
	}

	@Transactional
	public void create() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the name: ");
		String name = scanner.next();
		System.out.print("Enter the lastname: ");
		String lastname = scanner.next();
		System.out.print("Enter the programming Language:");
		String programmingLanguage = scanner.next();
		scanner.close();

		Person person = new Person(null, name, lastname, programmingLanguage);
		repository.save(person);

		Long personId = person.getId();

		if (personId != null) {
			repository.findById(personId).ifPresentOrElse(p -> {
				System.out.println(p.toString());
			}, () -> System.out.println("ID" + personId + " not found"));
		}

	}

	@Transactional
	public void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id for update a person");
		Long id = scanner.nextLong();

		Optional<Person> personid = repository.findById(id);

		// if (!personid.isPresent()) {
		// System.out.println("Id not found");
		// }

		personid.ifPresentOrElse(person -> {
			System.out.println("Enter the name to update");
			String name = scanner.next();
			person.setName(name);

			System.out.println("Enter the lastname to update");
			String lastname = scanner.next();
			person.setLastname(lastname);

			System.out.println("Enter the programming language to update");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);

			repository.save(person);
			System.out.println(person.toString());
		}, () -> System.out.println("ID: " + personid + " not found"));

		scanner.close();

	}

	@Transactional
	public void remove() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id for delete");
		Long id = scanner.nextLong();

		repository.deleteById(id);

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void remove2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id for delete");
		Long id = scanner.nextLong();

		Optional<Person> personId = repository.findById(id);

		// personId.ifPresentOrElse(person -> {
		// if (person != null) {
		// repository.delete(person);
		// }
		// }, () -> System.out.println("ID not found"));

		personId.ifPresentOrElse(repository::delete, () -> System.out.println("ID not found"));

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void methodReturnStringFromPerson() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Witch is the name");
		String name = scanner.next();

		Optional<String> personName = repository.getNameFromPerson(name);

		personName.ifPresentOrElse(person -> {
			System.out.println("Name of the person is: " + personName);

		}, () -> System.out.println("Name not found"));

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void methodReturnNameById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Name query by id");
		System.out.println("Enter the id");
		Long id = scanner.nextLong();

		Optional<String> personById = repository.getNameById(id);

		personById.ifPresentOrElse(person -> {
			System.out.println("Name of the person by id is: " + personById);

		}, () -> System.out.println("The name not found"));

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void methodReturnLastnameById() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Lastname query by id");
		System.out.println("Enter the id");
		Long id = scanner.nextLong();

		Optional<String> personLastname = repository.getLastnameById(id);

		personLastname.ifPresentOrElse(person -> {
			System.out.println("Person lastname is: " + personLastname);

		}, () -> System.out.println("Lastname not found"));

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void methodReturnProgrammingLanguage() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Programming Language query by id");
		System.out.println("Enter the id");
		Long id = scanner.nextLong();

		Optional<String> personProgrammingLanguage = repository.getProgrammingLanguage(id);

		personProgrammingLanguage.ifPresentOrElse(person -> {
			System.out.println("Person programming language is: " + personProgrammingLanguage);

		}, () -> System.out.println("The id not found"));

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void methodReturnIdByName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = scanner.next();

		Optional<Long> personId = repository.getIdByName(name);

		personId.ifPresentOrElse(person -> {
			System.out.println("Person id is: " + personId);

		}, () -> System.out.println("Person not found"));

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void methodReturnFullNameById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id");
		Long id = scanner.nextLong();

		Optional<String> personId = repository.getFullNameById(id);

		personId.ifPresentOrElse(person -> {
			System.out.println("Person fullname is: " + person);

		}, () -> System.out.println("Person not found"));

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void personalizeQuery() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("======= Name query by id =======");
		System.out.println("Enter the id");
		Long id = scanner.nextLong();
		scanner.close();

		System.out.println("===== Showing only the name =====");
		Optional<String> name = repository.getNameById(id);
		System.out.println(name);

		System.out.println("===== Showing only the id =====");
		Optional<Long> idDb = repository.getIdById(id);
		System.out.println(idDb);

		System.out.println("===== Showing fullname with concat =====");
		Optional<String> fullname = repository.getFullNameById(id);
		System.out.println(fullname);

		System.out.println("==== query for custom fields by id ====");
		Optional<Object> optionalReg = repository.getPersonDataById(id);
		System.out.println(optionalReg);

	}

	@Transactional(readOnly = true)
	public void personalizeQuery2() {

		System.out.println("===== Query by person object and programming language");
		List<Object[]> personRegs = repository.findAllMixPerson();
		personRegs.forEach(
				person -> System.out.println("Programming Language= " + person[1] + " person= " + person[0]));

		System.out.println("Query that populates and returns object entity from a custom class");
		List<Person> persons = repository.findAllPersonObjectPersonalized();
		persons.forEach(System.out::println);

		System.out.println("Query that populates and returns dto from a custom class");
		List<PersonDto> personDto = repository.findAllPersonDto();
		personDto.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizeQueryDistinct() {
		System.out.println("====== Query with name of persons ======");
		List<String> personsNames = repository.findAllNames();
		personsNames.forEach(System.out::println);

		System.out.println("====== Query with distinct names of persons ======");
		List<String> personNamesDistinct = repository.findAllDistinctNames();
		personNamesDistinct.forEach(System.out::println);

		System.out.println("====== Query with programming language of persons ======");
		List<String> personProgrammingLanguage = repository.findAllProgrammingLanguage();
		personProgrammingLanguage.forEach(System.out::println);

		System.out.println("====== Query with distinct programming language of persons ======");
		List<String> personDistinctProgrammingLanguage = repository.findAllDistinctProgrammingLanguage();
		personDistinctProgrammingLanguage.forEach(System.out::println);

		System.out.println("====== Query with total distinct programming language of persons ======");
		Long personCountDistinctProgrammingLanguage = repository.findAllCountDistinctProgrammingLanguage();
		System.out.println("Total Programming language: " + personCountDistinctProgrammingLanguage);

	}

	@Transactional(readOnly = true)
	public void personalizedQueriesConcatUpperAndLowerCase() {

		System.out.println("====== Query return total fullname concat = ====");
		List<String> allFullnameConcatOfPerson = repository.findAllFullnameConcat();
		allFullnameConcatOfPerson.forEach(System.out::println);

		System.out.println("====== Query return upper fullname ======");
		List<String> upperFullname = repository.findAllFullnameConcatUpper();
		upperFullname.forEach(System.out::println);

		System.out.println("====== Query return lower fullname ======");
		List<String> lowerFullname = repository.findAllFullnameConcatLower();
		lowerFullname.forEach(System.out::println);

		System.out.println("====== Query return full persons data list case ====== ");
		List<Object[]> fullPersonData = repository.findAllPersonDataListCase();
		fullPersonData.forEach(person -> {
			System.out.println(
					"person= " + person[0] + " lastname= " + person[1] + " programming language= " + person[2]);
		});
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesBetween() {

		System.out.println("======= Query by ranks =======");
		System.out.println("=== Query  return all person data by id ===");
		List<Person> betweenPersonId = repository.findAllBetweenPersonId();
		betweenPersonId.forEach(System.out::println);

		System.out.println("=== Query  return all person data by name ===");
		List<Person> betweenPersonName = repository.findAllBetweenPersonName();
		betweenPersonName.forEach(System.out::println);

	}

	@Transactional(readOnly = true)
	public void personalizedQueriesBetweenScanner() {
		System.out.println("======= Query by ranks =======");

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the id 1: ");
		Long idOne = scanner.nextLong();
		System.out.print("Enter the id 2: ");
		Long idTwo = scanner.nextLong();

		List<Person> personIdBetween = repository.findAllBetweenPersonIdByScanner(idOne, idTwo);

		personIdBetween.forEach(System.out::println);

		System.out.print("Enter the character one: ");
		String charOne = scanner.next();
		System.out.print("Enter the character one: ");
		String charTwo = scanner.next();

		List<Person> personBetweenChar = repository.findAllBetweenPersonNameByScanner(charOne, charTwo);
		personBetweenChar.forEach(System.out::println);

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void customQueriesPerson() {
		System.out.println("All persons Name order by asc");
		List<Person> allPersonName = repository.getAllPersonOrderedById();
		allPersonName.forEach(System.out::println);

		System.out.println("All persons Id order by asc");
		List<Person> allPersonId = repository.getAllPersonOrderedById();
		allPersonId.forEach(System.out::println);

	}

	@Transactional(readOnly = true)
	public void customQueriesPersonReturnFunctionAggregation() {

		Long totalPerson = repository.getTotalPerson();
		System.out.println("Total person in database: " + totalPerson);

		Long minId = repository.getMinIdPerson();
		System.out.println("Minimun id from Person: " + minId);

		Long maxId = repository.getMaxIdPerson();
		System.out.println("Maximum id from Person: " + maxId);

		System.out.println("Query by the name and its length");
		List<Object[]> personNameLength = repository.getPersonNameLength();
		personNameLength.forEach(person -> {
			String name = (String) person[0];
			Integer lenght = (Integer) person[1];

			System.out.println("Name = " + name + " length = " + lenght);
		});

		Integer minLengthPerson = repository.getMinLengthName();
		System.out.println("Min length name in table Person is: " + minLengthPerson);

		Integer maxLengthPerson = repository.getMaxLengthName();
		System.out.println("Max length name in table Person is: " + maxLengthPerson);

		Object[] resumeReg = (Object[]) repository.getResumeAggregationFuntion();

		System.out.println("Min: " + resumeReg[0] + ", Max:" + resumeReg[1] + ", Sum: " + resumeReg[2] + ", Avg: "
				+ resumeReg[3] + ", Count: " + resumeReg[4]);
	}

	@Transactional(readOnly = true)
	public void subQueries() {
		System.out.println("==== Consulta por el nombre mas corto y su 	largo ====");
		List<Object[]> register = repository.getShorterName();

		register.forEach(reg -> {
			String name = (String) reg[0];
			Integer nameLength = (Integer) reg[1];
			System.out.println("Name: " + name + " length: " + nameLength);
		});

		System.out.println("===== Consulta para obtener el ultimo id");
		Optional<Person> lastPersonRegisration = repository.getLastRegistration();

		lastPersonRegisration.ifPresentOrElse(person -> {
			System.out.println("Last person register id: " + person);
		}, () -> System.out.println("Register not found"));

	}

	@Transactional(readOnly = true)
	public void whereIn(){
		System.out.println("==== Consulta por where in ====");

		List<Person> persons = repository.getPersonByIds(List.of(1L, 2L, 3L, 4L, 7L, 10L));
		persons.forEach(System.out::println);
	}
}
