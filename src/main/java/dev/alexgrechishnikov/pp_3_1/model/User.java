package dev.alexgrechishnikov.pp_3_1.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Field not be Empty")
    @Size(min = 2, max = 20, message = "The allowed length is from 2 to 20 characters")
    private String name;

    @NotEmpty(message = "Field not be Empty")
    @Size(min = 2, max = 20, message = "The allowed length is from 2 to 20 characters")
    private String lastName;

    @Positive(message = "Field not be Negative")
    @Max(value = 127, message = "Not be bigger than 127 (format range)")
    private byte age;

    public User() {
    }

    public User(String name, String lastName, byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("User{id='%d', name='%s', lastName='%s', age='%d'",
                id, name, lastName, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}