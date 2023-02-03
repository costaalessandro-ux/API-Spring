package com.example.api.controller;

import com.example.api.domain.DadosAutenticacao;
import com.example.api.domain.usuario.Usuario;
import com.example.api.infra.DadosTokenJWT;
import com.example.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager maneger;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
           var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
           var authentication = maneger.authenticate(authenticationToken );
           var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
           return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}