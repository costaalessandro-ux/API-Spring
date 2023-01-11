package com.example.api.paciente;

import com.example.api.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        // estamos utilizando bean validation
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        @NotNull @Valid
        DadosEndereco endereco
) {

}
