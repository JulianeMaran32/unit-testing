package com.juhmaran.showcase.testingrestapi.service;

import com.juhmaran.showcase.testingrestapi.exceptions.PersonNotFoundException;
import com.juhmaran.showcase.testingrestapi.model.Person;
import com.juhmaran.showcase.testingrestapi.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<Person> findAll() {
        log.info("Finding all people!");
        return repository.findAll();
    }

    public Optional<Person> findById(Long id) {
        log.info("Finding one person!");
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No records found for this ID!")));
    }

    public Person create(Person person) {
        log.info("Creating one person!");
        Optional<Person> savedPerson = repository.findByEmail(person.getEmail());
        if (savedPerson.isPresent()) {
            throw new PersonNotFoundException("Person already exist with given e-Mail: " + person.getEmail());
        }
        return repository.save(person);
    }

    public Person update(Person person) {
        log.info("Updating one person!");
        var response = repository.findById(person.getId())
                .orElseThrow(() -> new PersonNotFoundException("No records found for this ID!"));
        response.setFirstName(person.getFirstName());
        response.setLastName(person.getLastName());
        response.setAddress(person.getAddress());
        response.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id) {
        log.info("Deleting one person!");
        var response = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No records found for this ID!"));
        repository.delete(response);
    }

}
