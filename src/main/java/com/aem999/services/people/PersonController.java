package com.aem999.services.people;

import com.aem999.domain.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/api/people/{id}", method = RequestMethod.GET)
    public Person person(@PathVariable long id) {
        return personService.get(id);
    }

    @RequestMapping(value = "/api/people", method = RequestMethod.GET)
    public Iterable<Person> people() {
        return personService.getAll();
    }

    @RequestMapping(value = "/api/people", method = RequestMethod.POST)
    public Person create(@RequestBody Person newPerson) {
        return personService.save(newPerson);
    }

}
