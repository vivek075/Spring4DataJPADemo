package com.example.service;

import com.example.entity.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonServiceTest {

    private PersonService personService;

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        personService = context.getBean(PersonService.class);
    }

    @Test
    public void testCRUDOperations() {
        // Create
        Person Person = new Person();
        Person.setName("John Doe");
        Person.setEmail("john.doe@example.com");
        Person = personService.savePerson(Person);
        Assert.assertNotNull(Person.getId());

        // Read
        Person retrievedPerson = personService.findPersonById(Person.getId());
        Assert.assertEquals("John Doe", retrievedPerson.getName());

        // Update
        retrievedPerson.setName("Jane Doe");
        personService.savePerson(retrievedPerson);
        Person updatedPerson = personService.findPersonById(retrievedPerson.getId());
        Assert.assertEquals("Jane Doe", updatedPerson.getName());

        // Delete
        personService.deletePerson(updatedPerson.getId());
        Person deletedPerson = personService.findPersonById(updatedPerson.getId());
        Assert.assertNull(deletedPerson);
    }
}
