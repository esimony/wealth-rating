package com.nice.wealthrating;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rich {
    @Id
    @GeneratedValue()
    private String id;
    private String firstName;
    private String lastName;
    private long   fortune;

    public Rich() {
    }

    public Rich(String id, String firstName, String lastName, long fortune) {
        this.id        = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.fortune   = fortune;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getFortune() {
        return fortune;
    }

    public void setFortune(long fortune) {
        this.fortune = fortune;
    }

    @Override
    public String toString() {
        return "{ " +
                "id='"        + id        + "', " +
                "firstName='" + firstName + "', " +
                "lastName='"  + lastName  + "', " +
                "fortune='"   + fortune   + "' "  +
                '}';
    }
}
