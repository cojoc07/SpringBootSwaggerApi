package com.stefan.info.controller.dto;

import com.stefan.info.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponseRepresentation {
    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String email;
    @JsonProperty
    private String username;

    public static UserResponseRepresentation convert(User user){
        return new UserResponseRepresentation(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUsername()
        );
    }

    private UserResponseRepresentation(int id, String name, String email, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
    }
}
