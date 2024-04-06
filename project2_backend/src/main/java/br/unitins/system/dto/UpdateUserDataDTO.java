package br.unitins.system.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserDataDTO(
    @NotBlank(message = "O campo \"senha antiga\" não pode ser nulo")
    String cpf,

    @NotBlank(message = "O campo \"senha nova\" não pode ser nulo")
    String name,

    @NotBlank(message = "O campo \"senha nova\" não pode ser nulo")
    String email,

    @NotBlank(message = "O campo \"senha nova\" não pode ser nulo")
    String phoneNumber
) {
    
}
