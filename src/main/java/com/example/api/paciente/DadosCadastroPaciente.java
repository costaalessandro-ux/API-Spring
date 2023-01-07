package com.example.api.paciente;

import com.example.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {

}
