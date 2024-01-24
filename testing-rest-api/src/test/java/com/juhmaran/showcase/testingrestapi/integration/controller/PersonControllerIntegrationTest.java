package com.juhmaran.showcase.testingrestapi.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juhmaran.showcase.testingrestapi.config.ConfigTest;
import com.juhmaran.showcase.testingrestapi.model.Person;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PersonControllerIntegrationTest {

    private static RequestSpecification specification;
    private static ObjectMapper objectMapper;
    private static Person person;

    @BeforeAll
    static void beforeAll() {

        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        specification = new RequestSpecBuilder()
                .setBasePath("/api/person")
                .setPort(ConfigTest.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        person = new Person(
                "John",
                "Doe",
                "john.doe@example.com",
                "123 Main St, Anytown, CA",
                "Male");

    }

    @Test
    @Order(1)
    @DisplayName("JUnit integration given Person Object when Create one Person should Return a Person Object")
    void integrationTestGivenPersonObject_when_CreateOnePerson_ShouldReturnAPersonObject()
            throws JsonMappingException, JsonProcessingException {

        var content = given().spec(specification)
                .contentType(ConfigTest.CONTENT_TYPE_JSON)
                .body(person)
                .when().post()
                .then().statusCode(200)
                .extract().body().asString();

        Person createdPerson = objectMapper.readValue(content, Person.class);

        person = createdPerson;

        assertNotNull(createdPerson);
        assertNotNull(createdPerson.getId());
        assertNotNull(createdPerson.getFirstName());
        assertNotNull(createdPerson.getLastName());
        assertNotNull(createdPerson.getAddress());
        assertNotNull(createdPerson.getGender());
        assertNotNull(createdPerson.getEmail());

        assertTrue(createdPerson.getId() > 0);
        assertEquals("John", createdPerson.getFirstName());
        assertEquals("Doe", createdPerson.getLastName());
        assertEquals("john.doe@example.com", createdPerson.getEmail());
        assertEquals("Male", createdPerson.getGender());
        assertEquals("123 Main St, Anytown, CA", createdPerson.getAddress());

    }

    @Test
    @Order(2)
    @DisplayName("JUnit integration given Person Object when Update one Person should Return a Updated Person Object")
    void integrationTestGivenPersonObject_when_UpdateOnePerson_ShouldReturnAUpdatedPersonObject() throws JsonMappingException, JsonProcessingException {

        person.setFirstName("John");
        person.setEmail("john.doe@example.com");

        var content = given().spec(specification)
                .contentType(ConfigTest.CONTENT_TYPE_JSON)
                .body(person)
                .when()
                .put()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        Person updatedPerson = objectMapper.readValue(content, Person.class);

        person = updatedPerson;

        assertNotNull(updatedPerson);

        assertNotNull(updatedPerson.getId());
        assertNotNull(updatedPerson.getFirstName());
        assertNotNull(updatedPerson.getLastName());
        assertNotNull(updatedPerson.getAddress());
        assertNotNull(updatedPerson.getGender());
        assertNotNull(updatedPerson.getEmail());

        assertTrue(updatedPerson.getId() > 0);
        assertEquals("John", updatedPerson.getFirstName());
        assertEquals("Doe", updatedPerson.getLastName());
        assertEquals("123 Main St, Anytown, CA", updatedPerson.getAddress());
        assertEquals("Male", updatedPerson.getGender());
        assertEquals("john.doe@example.com", updatedPerson.getEmail());
    }

    @Test
    @Order(3)
    @DisplayName("JUnit integration given Person Object when findById should Return a Person Object")
    void integrationTestGivenPersonObject_when_findById_ShouldReturnAPersonObject()
            throws JsonMappingException, JsonProcessingException {

        var content = given().spec(specification)
                .pathParam("id", person.getId())
                .when().get("{id}")
                .then().statusCode(200)
                .extract().body().asString();

        Person foundPerson = objectMapper.readValue(content, Person.class);

        person = foundPerson;

        assertNotNull(foundPerson);

        assertNotNull(foundPerson.getId());
        assertNotNull(foundPerson.getFirstName());
        assertNotNull(foundPerson.getLastName());
        assertNotNull(foundPerson.getAddress());
        assertNotNull(foundPerson.getGender());
        assertNotNull(foundPerson.getEmail());

        assertTrue(foundPerson.getId() > 0);
        assertEquals("John", foundPerson.getFirstName());
        assertEquals("Doe", foundPerson.getLastName());
        assertEquals("123 Main St, Anytown, CA", foundPerson.getAddress());
        assertEquals("Male", foundPerson.getGender());
        assertEquals("john.doe@example.com", foundPerson.getEmail());

    }

    @Test
    @Order(4)
    @DisplayName("JUnit integration given Person Object when findAll should Return a Persons List")
    void integrationTest_when_findAll_ShouldReturnAPersonsList()
            throws JsonMappingException, JsonProcessingException {

        Person anotherPerson = new Person(
                "Jane",
                "Smith",
                "jane.smith@example.com",
                "456 Elm St, Anytown, CA",
                "Female");

        given().spec(specification)
                .contentType(ConfigTest.CONTENT_TYPE_JSON)
                .body(anotherPerson)
                .when().post()
                .then().statusCode(200);

        var content = given().spec(specification)
                .when().get()
                .then().statusCode(200)
                .extract().body().asString();

        Person[] myArray = objectMapper.readValue(content, Person[].class);
        List<Person> people = Arrays.asList(myArray);

        Person foundPersonOne = people.get(0);

        assertNotNull(foundPersonOne);

        assertNotNull(foundPersonOne.getId());
        assertNotNull(foundPersonOne.getFirstName());
        assertNotNull(foundPersonOne.getLastName());
        assertNotNull(foundPersonOne.getAddress());
        assertNotNull(foundPersonOne.getGender());
        assertNotNull(foundPersonOne.getEmail());

        assertTrue(foundPersonOne.getId() > 0);
        assertEquals("John", foundPersonOne.getFirstName());
        assertEquals("Doe", foundPersonOne.getLastName());
        assertEquals("123 Main St, Anytown, CA", foundPersonOne.getAddress());
        assertEquals("Male", foundPersonOne.getGender());
        assertEquals("john.doe@example.com", foundPersonOne.getEmail());

    }

    @Test
    @Order(5)
    @DisplayName("JUnit integration given Person Object when delete should Return No Content")
    void integrationTestGivenPersonObject_when_delete_ShouldReturnNoContent()
            throws JsonMappingException, JsonProcessingException {

        given().spec(specification)
                .pathParam("id", person.getId())
                .when().delete("{id}")
                .then().statusCode(204);

    }

}
