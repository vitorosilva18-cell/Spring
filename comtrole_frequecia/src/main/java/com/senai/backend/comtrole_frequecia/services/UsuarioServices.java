package com.senai.backend.comtrole_frequecia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.comtrole_frequecia.models.usuario;
import com.senai.backend.comtrole_frequecia.repositories.UsuarioRepository;

import jakarta.persistence.Id;

@Service
public class UsuarioServices {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Long contarusuario(){
        return usuarioRepository.count();
    }

    public usuario buscarUsuario(Integer id){
        return usuarioRepository.findById(id).get();
    }

    public List<usuario> ListarUsuario(){
        return usuarioRepository.findAll();
    }

    public Boolean deletarUsuario(Integer id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;

        }
        return false;
    }

    public usuario cadastraUsuario(usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    public usuario atualUsuario(Integer id, usuario usuario){
    usuario usuarioRecuperado = buscarUsuario(id);
        if (usuarioRecuperado != null){
            usuarioRecuperado.setId(id);
            if (usuario.getNome() != null){
                usuarioRecuperado.setNome(usuario.getNome());
            }
            if(usuario.getDataNascimento() !=null){
                usuarioRecuperado.setDataNascimento(usuario.getDataNascimento());
            }
            return usuarioRepository.save(usuarioRecuperado);
        }
        return null;
    }
}
