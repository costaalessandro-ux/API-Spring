package com.example.api.controller;

import com.example.api.endereco.Endereco;
import com.example.api.medico.DadosCadastradosMedico;
import com.example.api.medico.Medico;
import com.example.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

// o spring utiliza a notações, a anotação @RestController é para referenciar a que nossa classe faz parte de
// um controller;
// @RequestMapping faz com que a classe possua uma URL;
// @PostMapping diz que a o metodo vai receber uma requisição post;
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastradosMedico dados){
        repository.save(new Medico(dados));
    }


}
