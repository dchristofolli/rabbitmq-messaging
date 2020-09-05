package com.dchristofolli.messagingrabbitmq.model;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private String id;
    private String name;
    private String cpf;
    private String email;
    private String password;

    public UserEntity(String id, String name, String cpf, String email, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", cpf='" + cpf + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
