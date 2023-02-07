package com.example.api.infra.security;

import com.example.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    var tokenJWT = recuperarToken(request);
        System.out.println("Token recebido: " +tokenJWT);
    if(tokenJWT != null){
        System.out.print("Entrou no Filtro");
        var subject = tokenService.getSubject(tokenJWT);
        var usuario = repository.findByLogin(subject);
        System.out.println("Usuario: " +usuario);
        var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.print("LOGADO");
    }
    filterChain.doFilter(request, response);
}

    public String recuperarToken(HttpServletRequest request){
        var authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader != null){
            return authorizationHeader.replace("Bearer", "");
        }
       return null;
    }

}
