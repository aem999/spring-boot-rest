package com.aem999.services.people;

import com.aem999.domain.Person;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    Person get(long id) {
        return new Person(1L, "Albert", null, "Einstein", 76);
    }
}
