package com.example.api.medico;

import com.example.api.endereco.DadosEndereco;

public record DadosCadastradosMedico(String nome, String email, String telefone, String crm, Especialidade especialidade, DadosEndereco endereco) {

}


