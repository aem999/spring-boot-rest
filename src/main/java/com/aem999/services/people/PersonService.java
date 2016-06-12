package com.aem999.services.people;

import com.aem999.domain.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person get(long id) {
        return repository.findOne(id);
    }

    public Iterable<Person> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = false)
    public Person save(Person newPerson) {
        return repository.save(newPerson);
    }

    @Transactional(readOnly = false)
    public void delete(long id) {
        repository.delete(id);
    }
}
