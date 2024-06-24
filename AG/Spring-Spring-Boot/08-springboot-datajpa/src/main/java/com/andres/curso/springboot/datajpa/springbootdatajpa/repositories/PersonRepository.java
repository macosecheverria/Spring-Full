package com.andres.curso.springboot.datajpa.springbootdatajpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.andres.curso.springboot.datajpa.springbootdatajpa.dtos.PersonDto;
import com.andres.curso.springboot.datajpa.springbootdatajpa.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    // metodos que devuelven listas List<Person>
    // los que tiene la anotacion @Query son consultas personalizadas
    @Query("select p from Person p where p.programmingLanguage=?1")
    List<Person> findByProgrammingLanguageList(String programmingLanguage);

    @Query("select p from Person p")
    List<Person> findAllPerson();

    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2 ")
    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtainPersonData();

    @Query("select p.name, p.programmingLanguage from Person p where p.name=?1 and p.programmingLanguage=?2")
    List<Object[]> obtainPersonData(String name, String programmingLanguage);

    @Query("select p from Person p where p.programmingLanguage=?1")
    List<Person> obtainPersonDataByProgrammingLanguage(String programminLanguage);

    @Query("select p from Person p where p.name=?1")
    List<Person> obtainPersonDataByName(String name);

    // metodos que devuelven solo la clase Person
    // metodos por defecto que trae de forma automatica de la implementacion de jpa
    // Jpa
    Optional<Person> findByName(String name);

    Optional<Person> findByLastname(String name);

    Optional<Person> findByProgrammingLanguage(String programmingLanguage);

    // metodos que devuelven una cosulta personalizada
    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneByName(String name);

    @Query("select p from Person p where p.name like  %?1%")
    Optional<Person> findOneLikeName(String name);

    @Query("select p from Person p where p.lastname=?1")
    Optional<Person> findOneByLastname(String lastname);

    @Query("select p from Person p where p.programmingLanguage=?1")
    Optional<Person> findOneByProgrammingLanguage(String programmingLanguage);

    // metodos que devuelve consultas personalizadas con el tipo de dato del
    // atributo

    @Query("select p.name from Person p where p.name=?1")
    Optional<String> getNameFromPerson(String name);

    @Query("select p.name from Person p where p.id=?1")
    Optional<String> getNameById(Long id);

    @Query("select p.lastname from Person p where p.id=?1")
    Optional<String> getLastnameById(Long id);

    @Query("select p.programmingLanguage from Person p where p.id=?1")
    Optional<String> getProgrammingLanguage(Long id);

    @Query("select p.id from Person p where p.name=?1")
    Optional<Long> getIdByName(String name);

    @Query("select p.id from Person p where p.id=?1")
    Optional<Long> getIdById(Long id);

    @Query("select concat(p.name, ' ' ,p.lastname) from Person p where p.id=?1")
    Optional<String> getFullNameById(Long id);

    @Query("select p.name, p.lastname, p.programmingLanguage from Person p")
    List<Object[]> getPersonDataList();

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id=?1")
    Optional<Object> getPersonDataById(Long id);

    // consultas personalizadas que retornan una lista o solo un tipo de dato
    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllPersonObjectPersonalized();

    @Query("select new  com.andres.curso.springboot.datajpa.springbootdatajpa.dtos.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllPersonDto();

    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select distinct(p.name) from Person p")
    List<String> findAllDistinctNames();

    @Query("select p.programmingLanguage from Person p")
    List<String> findAllProgrammingLanguage();

    @Query("select distinct(p.programmingLanguage) from Person p")
    List<String> findAllDistinctProgrammingLanguage();

    @Query("select count(distinct(p.programmingLanguage)) from Person p")
    Long findAllCountDistinctProgrammingLanguage();

    // @Query("select CONCAT(p.name,' ' ,p.lastname) from Person p")
    @Query("select p.name || ' '  || p.lastname from Person p")
    List<String> findAllFullnameConcat();

    @Query("select upper(p.name || ' ' || p.lastname) from Person p")
    List<String> findAllFullnameConcatUpper();

    @Query("select lower(concat(p.name, ' ' , p.lastname)) from Person p")
    List<String> findAllFullnameConcatLower();

    @Query("select upper(p.name), lower(p.lastname), upper(p.programmingLanguage) from Person p")
    List<Object[]> findAllPersonDataListCase();

    @Query("select p from Person p where p.id between 2 and 5")
    List<Person> findAllBetweenPersonId();

    @Query("select p from Person p where p.name between 'J' and 'P'")
    List<Person> findAllBetweenPersonName();

    @Query("select p from Person p where p.id between ?1 and ?2 order by p.name asc")
    List<Person> findAllBetweenPersonIdByScanner(Long idOne, Long idTwo);

    @Query("select p from Person p where p.name between ?1 and ?2 order by p.name desc, p.lastname asc")
    List<Person> findAllBetweenPersonNameByScanner(String charOne, String charTwo);

    // consultas por defectos de jpa
    List<Person> findByIdBetween(Long idOne, Long idTwo);

    List<Person> findByNameBetween(String charOne, String charTwo);

    List<Person> findByNameBetweenOrderByNameDescLastnameAsc(String charOne, String charTwo);

    // custom queries return all person by asc desc
    @Query("select p from Person p order by p.name asc")
    List<Person> getAllPersonOrderedByName();

    @Query("select p from Person p order by p.id desc")
    List<Person> getAllPersonOrderedById();

    // custom queries function 

    @Query("select count(p) from Person p")
    Long getTotalPerson();

    @Query("select min(p.id) from Person p")
    Long getMinIdPerson();

    @Query("select max(p.id) from Person p")
    Long getMaxIdPerson();

    @Query("select p.name, length(p.name) from Person p")
    List<Object[]> getPersonNameLength();

    @Query("select min(length(p.name)) from Person p")
    Integer getMinLengthName();

    @Query("select max(length(p.name)) from Person p")
    Integer getMaxLengthName();

    @Query("select min(p.id), max(p.id), sum(p.id), avg(length(p.name)), count(p.id) from Person p")
    Object getResumeAggregationFuntion();


    // sub queries
    @Query("select p.name , length(p.name) from Person p where length(p.name)=(select min(length(p.name)) from Person p)")
    List<Object[]> getShorterName(); 

    @Query("select p from Person p where p.id=(select max(p.id) from Person p)")
    Optional<Person> getLastRegistration();

    @Query("select p from Person p where p.id in ?1")
    List<Person> getPersonByIds(List<Long> ids);

    @Query("select p from Person p where p.id not in ?1")
    List<Person> getPersonByNotInIds(List<Long> ids);
}