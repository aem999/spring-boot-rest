package com.aem999.services.people;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.aem999.domain.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST API for {@link Person} resource.
 */
@Api(tags = {"People"}, description = "REST API")
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @ApiOperation(value = "Get person by id")
    @RequestMapping(value = "/api/people/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public Person person(@PathVariable long id) {
        return personService.get(id);
    }

    @ApiOperation(value = "Get all people")
    @RequestMapping(value = "/api/people", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public Iterable<Person> people() {
        return personService.getAll();
    }

    @ApiOperation(value = "Create a new person")
    @ApiResponse(code = 201, message = "Person was created successfully")
    @RequestMapping(value = "/api/people", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person create(@RequestBody Person newPerson) {
        return personService.save(newPerson);
    }

    @ApiOperation(value = "Delete person")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Person was deleted successfully"),
            @ApiResponse(code = 404, message = "Person does not exist")
    })
    @RequestMapping(value = "/api/people/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable long id) {
        try {
            personService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
