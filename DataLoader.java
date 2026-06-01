package com.exemplo.auth;

import com.exemplo.auth.entity.Usuario;
import com.exemplo.auth.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) {
        usuarioRepository.save(new Usuario("admin", "1234"));
        usuarioRepository.save(new Usuario("joao", "senha123"));
    }
}
