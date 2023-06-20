package ru.job4j.dreamjob.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class User {
    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "email", "email",
            "name", "name",
            "password", "password",
            "creation_date", "creationDate"
    );
    private int id;
    private String email;
    private String name;
    private String password;
    private LocalDateTime creationDate = LocalDateTime.now();

    public User() {

    }

    public User(int id, String email, String name, String password, LocalDateTime creationDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.creationDate = creationDate;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{"
                + "id='" + id + '\''
                + ", email='" + email + '\''
                + ", name='" + name + '\''
                + ", password='" + password + '\''
                + '}';
    }
}
