package com.example.api.domain.paciente;

import com.example.api.domain.endereco.DadosEndereco;

import jakarta.validation.Valid;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}
