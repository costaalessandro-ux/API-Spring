package com.example.api.paciente;

import com.example.api.endereco.DadosEndereco;

import javax.validation.Valid;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}
