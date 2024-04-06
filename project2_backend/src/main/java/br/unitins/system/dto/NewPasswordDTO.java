package br.unitins.system.dto;

import jakarta.validation.constraints.NotBlank;

public record NewPasswordDTO(
    @NotBlank(message = "O campo \"senha antiga\" não pode ser nulo")
    String newPassword,

    @NotBlank(message = "O campo \"senha nova\" não pode ser nulo")
    String oldPassword
) {
    
}
