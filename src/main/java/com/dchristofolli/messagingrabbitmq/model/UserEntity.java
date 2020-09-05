package com.dchristofolli.messagingrabbitmq.model;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private static final long serialVersionUID = 7216203701057878501L;
    private String id;
    private String name;
    private String cpf;
    private String email;
    private String password;

    public UserEntity() {
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
