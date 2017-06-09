package com.bestdeals.returns.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"name" , "surname"})})
public class Client {

    @Id
    private Integer id;

    private String name, surname;

    public Client() {
    }

    public Client(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
