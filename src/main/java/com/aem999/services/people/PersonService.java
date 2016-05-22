package com.aem999.services.people;

import com.aem999.domain.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person get(long id) {
        return repository.findOne(id);
    }
}
