package com.dchristofolli.messagingrabbitmq.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private String id;
    private String name;
    private String cpf;
    private String email;

    public UserEntity() {
    }

    public UserEntity(@JsonProperty("name") String name,
                      @JsonProperty("cpf") String cpf,
                      @JsonProperty("email") String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
            "name='" + name + '\'' +
            ", cpf='" + cpf + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
