package com.aem999.services.people;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.aem999.SpringBootApp;
import com.aem999.domain.Person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Person Service Integration Test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootApp.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class PersonServiceIT {

    @Value("${local.server.port}")
    private int port;

    private URL baseURL;
    private RestTemplate template;


    @Before
    public void setUp() throws MalformedURLException {
        baseURL = new URL("http://localhost:" + port);
        template = new TestRestTemplate();
    }

    @Test
    public void should_return_a_single_person() {
        ResponseEntity<Person> response = template.getForEntity(baseURL.toExternalForm() + "/api/people/1", Person.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));

        Person person = response.getBody();
        assertThat(person.getId(), is(1L));
    }
}