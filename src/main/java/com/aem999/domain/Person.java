package com.aem999.domain;

/**
 * Person domain object.
 */
public class Person {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    public Person(long id, String firstName, String middleName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }

    Person() {
        // For Jackson/JPA
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Person person = (Person) other;

        if (getId() != person.getId()) {
            return false;
        }
        if (getAge() != person.getAge()) {
            return false;
        }
        if (!getFirstName().equals(person.getFirstName())) {
            return false;
        }
        if (getMiddleName() != null ? !getMiddleName().equals(person.getMiddleName()) : person.getMiddleName() != null) {
            return false;
        }
        return getLastName().equals(person.getLastName());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + (getMiddleName() != null ? getMiddleName().hashCode() : 0);
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        return "Person{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", middleName='" + middleName + '\''
                + ", lastName='" + lastName + '\''
                + ", age=" + age
                + '}';
    }
}
