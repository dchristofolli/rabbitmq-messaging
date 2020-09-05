package com.dchristofolli.messagingrabbitmq.model;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private final String id;
    private final String name;
    private final String cpf;
    private final String email;

    public UserEntity(String id, String name, String cpf, String email) {
        this.id = id;
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
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", cpf='" + cpf + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
