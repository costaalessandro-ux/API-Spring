package com.example.api.medico;

import com.example.api.endereco.DadosEndereco;

public record DadosCadastrados(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {

}


