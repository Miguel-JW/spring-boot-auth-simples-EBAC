package com.exemplo.auth.service;

import com.exemplo.auth.dto.LoginRequest;
import com.exemplo.auth.entity.Usuario;
import com.exemplo.auth.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String autenticar(LoginRequest request) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(request.getUsername());

        if (usuarioOpt.isEmpty()) {
            return "Erro: usuário não existe.";
        }

        Usuario usuario = usuarioOpt.get();

        if (!usuario.getSenha().equals(request.getSenha())) {
            return "Erro: senha incorreta.";
        }

        return "Autenticado com sucesso! Bem-vindo, " + usuario.getUsername() + ".";
    }
}
