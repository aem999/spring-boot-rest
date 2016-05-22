package com.aem999.services.people;

import com.aem999.domain.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
