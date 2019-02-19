package com.stefan.info.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequestRepresentation {
    @JsonIgnore
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String email;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;

    private UserRequestRepresentation(int id, String name, String email, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
