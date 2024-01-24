package com.juhmaran.showcase.testingrestapi.repository;

import com.juhmaran.showcase.testingrestapi.mock.MockPerson;
import com.juhmaran.showcase.testingrestapi.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    Person person;
    Person person1;

    @BeforeEach
    void setUp() {
        // Given / Arrange
        person = new Person(
                "John",
                "Doe",
                "john.doe@example.com",
                "123 Main St, Anytown, CA",
                "Male");
        person1 = new Person(
                "Jane",
                "Smith",
                "jane.smith@example.com",
                "456 Elm St, Anytown, CA",
                "Female");
    }

    @Test
    @DisplayName("JUnit test for Given person object when save then return saved person")
    void testGivenPersonObject_WhenSave_thenReturnSavedPerson() {

        // When / Act
        Person savedPerson = repository.save(person);

        // Then / Assert
        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0);

    }

    @Test
    @DisplayName("JUnit test for Given Person List when findAll then Return Person List")
    void testGivenPersonList_whenFindAll_thenReturnPersonList() {

        // Given / Arrange
        repository.save(person);
        repository.save(person1);

        // When / Act
        List<Person> personList = repository.findAll();

        // Then / Assert
        assertNotNull(personList);
        assertEquals(2, personList.size());

    }

    @Test
    @DisplayName("JUnit test for Given Person Object when findByID then Return Person Object")
    void testGivenPersonObject_whenFindByID_thenReturnPersonObject() {

        // Given / Arrange
        repository.save(person);

        // When / Act
        Person savedPerson = repository.findById(person.getId()).get();

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(person.getId(), savedPerson.getId());
    }

    @Test
    @DisplayName("JUnit test for Given Person Object when findByEmail then Return Person Object")
    void testGivenPersonObject_whenFindByEmail_thenReturnPersonObject() {

        // Given / Arrange
        repository.save(person);

        // When / Act
        Person savedPerson = repository.findByEmail(person.getEmail()).get();

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(person.getEmail(), savedPerson.getEmail());

    }

    @Test
    @DisplayName("JUnit test for Given Person Object when Update Person then Return Updated Person Object")
    void testGivenPersonObject_whenUpdatePerson_thenReturnUpdatedPersonObject() {

        // Given / Arrange
        repository.save(person);

        // When / Act
        Person savedPerson = repository.findById(person.getId()).get();
        savedPerson.setFirstName(MockPerson.FIRST_NAME_2);
        savedPerson.setEmail(MockPerson.EMAIL_2);

        Person updatePerson = repository.save(savedPerson);

        // Then / Assert
        assertNotNull(updatePerson);
        assertEquals(MockPerson.FIRST_NAME_2, savedPerson.getFirstName());
        assertEquals(MockPerson.EMAIL_2, savedPerson.getEmail());

    }

    @Test
    @DisplayName("JUnit test for Given Person Object when Update Person then Return Updated Person Object")
    void testGivenPersonObject_whenDelete_thenRemovePerson() {

        // Given / Arrange
        repository.save(person);

        // When / Act
        repository.deleteById(person.getId());
        Optional<Person> personOptional = repository.findById(person.getId());

        // Then / Assert
        assertTrue(personOptional.isEmpty());

    }

    @Test
    @DisplayName("JUnit test for Given firstName and lastName when findJPQL then Return Person Object")
    void testGivenFirstNameAndLastName_whenFindJPQL_thenReturnPersonObject() {

        // Given / Arrange
        repository.save(person);

        // When / Act
        Person savedPerson = repository
                .findByJPQL(MockPerson.FIRST_NAME_1, MockPerson.LAST_NAME_1);

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(MockPerson.FIRST_NAME_1, savedPerson.getFirstName());
        assertEquals(MockPerson.LAST_NAME_1, savedPerson.getLastName());

    }

    @Test
    @DisplayName("JUnit test for Given firstName and lastName when findByJPQLNamedParameters then Return Person Object")
    void testGivenFirstNameAndLastName_whenFindByJPQLNamedParameters_thenReturnPersonObject() {

        // Given / Arrange
        repository.save(person);

        // When / Act
        Person savedPerson = repository
                .findByJPQLNamedParameters(MockPerson.FIRST_NAME_1, MockPerson.LAST_NAME_1);

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(MockPerson.FIRST_NAME_1, savedPerson.getFirstName());
        assertEquals(MockPerson.LAST_NAME_1, savedPerson.getLastName());

    }

    @Test
    @DisplayName("JUnit test for Given firstName and lastName when findByNativeSQL then Return Person Object")
    void testGivenFirstNameAndLastName_whenFindByNativeSQL_thenReturnPersonObject() {

        // Given / Arrange
        repository.save(person);

        // When / Act
        Person savedPerson = repository
                .findByNativeJPQL(MockPerson.FIRST_NAME_1, MockPerson.LAST_NAME_1);

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(MockPerson.FIRST_NAME_1, savedPerson.getFirstName());
        assertEquals(MockPerson.LAST_NAME_1, savedPerson.getLastName());

    }

    @Test
    @DisplayName("JUnit test for Given firstName and lastName when findByNativeSQLwithNamedParameters then Return Person Object")
    void testGivenFirstNameAndLastName_whenFindByNativeSQLwithNamedParameters_thenReturnPersonObject() {

        // Given / Arrange
        repository.save(person);

        // When / Act
        Person savedPerson = repository
                .findByNativeSQLwithNamedParameters(MockPerson.FIRST_NAME_1, MockPerson.LAST_NAME_1);

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(MockPerson.FIRST_NAME_1, savedPerson.getFirstName());
        assertEquals(MockPerson.LAST_NAME_1, savedPerson.getLastName());

    }

}