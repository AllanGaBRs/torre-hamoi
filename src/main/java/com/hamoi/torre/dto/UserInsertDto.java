package com.hamoi.torre.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserInsertDto {

    @NotBlank(message = "Seu nick é obrigatório")
    private String name;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha precisa ter no mínimo 6 caracteres")
    private String password;

    public UserInsertDto(){

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
}
