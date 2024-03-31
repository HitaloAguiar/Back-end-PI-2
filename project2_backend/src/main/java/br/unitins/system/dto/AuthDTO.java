package br.unitins.system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class AuthDTO {
    @Email(message = "Insira um email válido")
    private String email;

    @Size(message = "O campo senha deve ser maior ou igual à 6", min = 6)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
