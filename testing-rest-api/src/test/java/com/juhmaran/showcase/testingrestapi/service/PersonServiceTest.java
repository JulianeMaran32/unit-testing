package com.juhmaran.showcase.testingrestapi.service;

import com.juhmaran.showcase.testingrestapi.exceptions.PersonNotFoundException;
import com.juhmaran.showcase.testingrestapi.mock.MockPerson;
import com.juhmaran.showcase.testingrestapi.model.Person;
import com.juhmaran.showcase.testingrestapi.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    List<Person> expectedPersons;

    Person person;
    Person person1;

    @InjectMocks
    PersonService service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUp() {
        // Given / Arrange
        service = new PersonService(repository);

        expectedPersons = List.of(
                new Person(1L, "John", "Doe",
                        "john.doe@example.com", "123 Main St, Anytown, CA", "Male"),
                new Person(2L, "Jane", "Smith",
                        "jane.smith@example.com", "456 Elm St, Anytown, CA", "Female"),
                new Person(3L, "Bob", "Johnson",
                        "bob.johnson@example.com", "789 Oak St, Anytown, CA", "Male"),
                new Person(4L, "Mary", "Williams",
                        "mary.williams@example.com", "100 Pine St, Anytown, CA", "Female"),
                new Person(5L, "David", "Lee",
                        "david.lee@example.com", "200 Maple St, Anytown, CA", "Male")
        );

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
    @DisplayName(value = "find all should return all persons from repository")
    void findAll_shouldReturnAllPersonsFromRepository() {
        when(repository.findAll()).thenReturn(expectedPersons);
        List<Person> actualPersons = service.findAll();
        assertEquals(expectedPersons, actualPersons);

    }

    @Test
    @DisplayName(value = "should return empty list when no persons are registered")
    void shouldReturnEmptyListWhenNoPersonsAreRegistered() {
        when(repository.findAll()).thenReturn(List.of());
        List<Person> persons = service.findAll();
        assertEquals(0, persons.size());
    }

    @Test
    @DisplayName(value = "should return person when ID exists")
    void shouldReturnPersonWhenIdExists() {
        Long existingId = 2L;
        Person expectedPerson = expectedPersons.get(1);
        when(repository.findById(existingId))
                .thenReturn(Optional.of(expectedPerson));
        Person foundPerson = service.findById(existingId).orElse(null);
        assertEquals(expectedPerson, foundPerson);
    }

    @Test
    @DisplayName(value = "should throw exception when ID does not exist")
    void shouldThrowExceptionWhenIdDoesNotExist() {
        when(repository.findById(MockPerson.NON_EXISTING_ID))
                .thenReturn(Optional.empty());
        assertThrows(PersonNotFoundException.class,
                () -> service.findById(MockPerson.NON_EXISTING_ID));
    }

    @DisplayName("JUnit test for Given Person Object when Save Person then Return Person Object")
    @Test
    void testGivenPersonObject_WhenSavePerson_thenReturnPersonObject() {

        // Given / Arrange
        given(repository.findByEmail(anyString())).willReturn(Optional.empty());
        given(repository.save(person)).willReturn(person);

        // When / Act
        Person savedPerson = service.create(person);

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(MockPerson.FIRST_NAME_1, savedPerson.getFirstName());
    }

    @DisplayName("JUnit test for Given Existing Email when Save Person then throws Exception")
    @Test
    void testGivenExistingEmail_WhenSavePerson_thenThrowsException() {

        // Given / Arrange
        given(repository.findByEmail(anyString())).willReturn(Optional.of(person));

        // When / Act
        assertThrows(PersonNotFoundException.class, () -> {
            service.create(person);
        });

        // Then / Assert
        verify(repository, never()).save(any(Person.class));
    }

    @DisplayName("JUnit test for Given Persons List when findAll Persons then Return Persons List")
    @Test
    void testGivenPersonsList_WhenFindAllPersons_thenReturnPersonsList() {

        // Given / Arrange

        given(repository.findAll()).willReturn(List.of(person, person1));

        // When / Act
        List<Person> personsList = service.findAll();

        // Then / Assert
        assertNotNull(personsList);
        assertEquals(2, personsList.size());
    }

    @DisplayName("JUnit test for Given Empty Persons List when findAll Persons then Return Empty Persons List")
    @Test
    void testGivenEmptyPersonsList_WhenFindAllPersons_thenReturnEmptyPersonsList() {

        // Given / Arrange
        given(repository.findAll()).willReturn(Collections.emptyList());

        // When / Act
        List<Person> personsList = service.findAll();

        // Then / Assert
        assertTrue(personsList.isEmpty());
        assertEquals(0, personsList.size());
    }

    @DisplayName("JUnit test for Given PersonId when findById then Return Person Object")
    @Test
    void testGivenPersonId_WhenFindById_thenReturnPersonObject() {

        // Given / Arrange
        given(repository.findById(anyLong())).willReturn(Optional.of(person));

        // When / Act
        Person savedPerson = service.findById(1L).get();

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(MockPerson.FIRST_NAME_1, savedPerson.getFirstName());
    }

    @DisplayName("JUnit test for Given Person Object when Update Person then Return Updated Person Object")
    @Test
    void testGivenPersonObject_WhenUpdatePerson_thenReturnUpdatedPersonObject() {

        // Given / Arrange
        person.setId(1L);
        given(repository.findById(anyLong())).willReturn(Optional.of(person));

        person.setFirstName(MockPerson.FIRST_NAME_1);
        person.setEmail(MockPerson.EMAIL_1);

        given(repository.save(person)).willReturn(person);

        // When / Act
        Person updatedPerson = service.update(person);

        // Then / Assert
        assertNotNull(updatedPerson);
        assertEquals(MockPerson.FIRST_NAME_1, updatedPerson.getFirstName());
        assertEquals(MockPerson.EMAIL_1, updatedPerson.getEmail());
    }

    @DisplayName("JUnit test for Given PersonID when Delete Person then do Nothing")
    @Test
    void testGivenPersonID_WhenDeletePerson_thenDoNothing() {

        // Given / Arrange
        person.setId(1L);
        given(repository.findById(anyLong())).willReturn(Optional.of(person));
        willDoNothing().given(repository).delete(person);

        // When / Act
        service.delete(person.getId());

        // Then / Assert
        verify(repository, times(1)).delete(person);
    }

}