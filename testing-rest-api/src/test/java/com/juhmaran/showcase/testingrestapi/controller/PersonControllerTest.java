package com.juhmaran.showcase.testingrestapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juhmaran.showcase.testingrestapi.exceptions.PersonNotFoundException;
import com.juhmaran.showcase.testingrestapi.model.Person;
import com.juhmaran.showcase.testingrestapi.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private PersonService service;

    Person person1;
    Person person2;
    List<Person> personList;

    @BeforeEach
    void setUp() {
        // Given / Arrange
        person1 = new Person(
                "Jane",
                "Smith",
                "jane.smith@example.com",
                "456 Elm St, Anytown, CA",
                "Female");

        person2 = new Person(
                "John",
                "Doe",
                "john.doe@example.com",
                "123 Main St, Anytown, CA",
                "Male");

        personList = List.of(
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

    }

    @Test
    @DisplayName("JUnit test for given person object when create person then return saved person")
    void testGivenPersonObject_WhenCreatePerson_thenReturnSavedPerson()
            throws JsonProcessingException, Exception {

        // Given / Arrange
        given(service.create(any(Person.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // When / Act
        ResultActions response = mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(person1)));

        // Then / Assert
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(person1.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(person1.getLastName())))
                .andExpect(jsonPath("$.email", is(person1.getEmail())));

    }

    @Test
    @DisplayName("JUnit test for given list of persons when find all persons then return persons")
    void testGivenListOfPersons_WhenFindAllPersons_thenReturnPersons()
            throws JsonProcessingException, Exception {

        // Given / Arrange
        given(service.findAll()).willReturn(personList);

        // When / Act
        ResultActions response = mockMvc.perform(get("/person"));

        // Then / Assert
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(personList.size())));

    }

    @Test
    @DisplayName("JUnit test for given personId when find by id then return person object")
    void testGivenPersonId_WhenFindById_thenReturnPersonObject()
            throws JsonProcessingException, Exception {

        // Given / Arrange
        Long personId = 1L;
        given(service.findById(personId)).willReturn(Optional.ofNullable(person1));

        // When / Act
        ResultActions response = mockMvc.perform(get("/person/{id}", personId));

        // Then / Assert
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(person1.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(person1.getLastName())))
                .andExpect(jsonPath("$.email", is(person1.getEmail())));

    }

    @Test
    @DisplayName("JUnit test for given invalid personId when find by id then return not found")
    void testGivenInvalidPersonId_WhenFindById_thenReturnNotFound()
            throws JsonProcessingException, Exception {

        // Given / Arrange
        Long personId = 1L;
        given(service.findById(personId)).willThrow(PersonNotFoundException.class);

        // When / Act
        ResultActions response = mockMvc.perform(get("/person/{id}", personId));

        // Then / Assert
        response.andExpect(status().isNotFound())
                .andDo(print());

    }

    @Test
    @DisplayName("JUnit test for given updated person when update then return updated person object")
    void testGivenUpdatedPerson_WhenUpdate_thenReturnUpdatedPersonObject()
            throws JsonProcessingException, Exception {

        // Given / Arrange
        Long personId = 1L;
        given(service.findById(personId))
                .willReturn(Optional.ofNullable(person1));
        given(service.update(any(Person.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // When / Act
        ResultActions response = mockMvc.perform(put("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(person2)));

        // Then / Assert
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(person2.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(person2.getLastName())))
                .andExpect(jsonPath("$.email", is(person2.getEmail())));

    }

    @Test
    @DisplayName("JUnit test for Given Unexistent Person when Update then Return Not Found")
    void testGivenUnexistentPerson_WhenUpdate_thenReturnNotFound()
            throws JsonProcessingException, Exception {

        // Given / Arrange
        Long personId = 1L;
        given(service.findById(personId))
                .willThrow(PersonNotFoundException.class);
        given(service.update(any(Person.class)))
                .willAnswer((invocation) -> invocation.getArgument(1));

        // When / Act
        ResultActions response = mockMvc.perform(put("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(person2)));

        // Then / Assert
        response.andExpect(status().isNotFound())
                .andDo(print());

    }

    @Test
    @DisplayName("JUnit test for Given personId when Delete then Return NotContent")
    void testGivenPersonId_WhenDelete_thenReturnNotContent()
            throws JsonProcessingException, Exception {

        // Given / Arrange
        Long personId = 1L;
        willDoNothing().given(service).delete(personId);

        // When / Act
        ResultActions response = mockMvc.perform(delete("/person/{id}", personId));

        // Then / Assert
        response.andExpect(status().isNoContent())
                .andDo(print());

    }

}