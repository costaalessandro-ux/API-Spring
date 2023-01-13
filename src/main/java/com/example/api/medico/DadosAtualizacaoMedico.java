package com.example.api.medico;

import com.example.api.endereco.DadosEndereco;

import javax.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {



}
