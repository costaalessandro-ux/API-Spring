package com.example.api.controller;

import com.example.api.endereco.Endereco;
import com.example.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

import static org.hibernate.criterion.Projections.id;

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
    public void cadastrar(@RequestBody @Valid DadosCadastradosMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> Listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivosTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

}
