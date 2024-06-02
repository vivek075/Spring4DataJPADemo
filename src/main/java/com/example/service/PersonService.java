package com.example.service;

import com.example.entity.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person Person) {
        return personRepository.save(Person);
    }

    public Person findPersonById(Long id) {
        return personRepository.findOne(id);
    }

    public Iterable<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(Long id) {
        personRepository.delete(id);
    }
}
