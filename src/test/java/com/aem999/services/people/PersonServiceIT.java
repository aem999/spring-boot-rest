package com.aem999.services.people;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import com.aem999.SpringBootApp;
import com.aem999.domain.Person;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Person Service Integration Test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootApp.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class PersonServiceIT {

    private static final Person ALBERT_EINSTEIN = new Person(1, "Albert", null, "Einstein", 76);
    private static final Person LEONARDO_DA_VINCI = new Person(2, "Leonardo", null, "Da Vinci", 67);


    @Value("${local.server.port}")
    private int port;

    private URL baseURL;
    private RestTemplate template;

    @Autowired
    private PersonRepository personRepository;


    @Before
    public void setUp() throws MalformedURLException {
        baseURL = new URL("http://localhost:" + port);
        template = new TestRestTemplate();
        template.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return !response.getStatusCode().is2xxSuccessful();
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                Assert.fail(String.format("Response = %d: %s", response.getStatusCode().value(), response.getStatusText()));
            }
        });
    }

    @Test
    public void should_return_a_single_person() {
        ResponseEntity<Person> response = template.getForEntity(baseURL.toExternalForm() + "/api/people/1", Person.class);
        Person person = response.getBody();
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(person, is(ALBERT_EINSTEIN));
    }

    @Test
    public void should_return_all_people() {
        ResponseEntity<Person[]> response = template.getForEntity(baseURL.toExternalForm() + "/api/people", Person[].class);
        Person[] people = response.getBody();
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(people, arrayContaining(ALBERT_EINSTEIN, LEONARDO_DA_VINCI));
    }

    @Test
    public void should_save_new_person() {
        Person isaacNewton = new Person(0, "Isaac", null, "Newton", 84);
        ResponseEntity<Person> response = template.postForEntity(baseURL.toExternalForm() + "/api/people", isaacNewton, Person.class);
        Person person = response.getBody();
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(person.getFirstName(), is("Isaac"));
        assertThat(person.getLastName(), is("Newton"));
        assertThat(person.getAge(), is(84));
    }

    @Test
    public void should_delete_person() throws URISyntaxException {
        Person savedPerson = personRepository.save(new Person(0, "Michelangelo", null, "Di Lodovico", 88));

        ResponseEntity<Void> response = template.exchange(baseURL.toExternalForm() + "/api/people/3", HttpMethod.DELETE, null, Void.class);
        assertThat(response.getStatusCode(), is(HttpStatus.NO_CONTENT));
        assertThat(personRepository.findOne(savedPerson.getId()), nullValue());
    }
}