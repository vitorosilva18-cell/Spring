package com.senai.backend.comtrole_frequecia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.comtrole_frequecia.models.usuario;
import com.senai.backend.comtrole_frequecia.services.UsuarioServices;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping("/contar-usuarios")
    public Long contarUsuarios(){
        return usuarioServices.contarusuario();
    }

    @GetMapping("/buscar-usuarios/{id}")
    public usuario buscarUsuario(@PathVariable Integer id){
        return usuarioServices.buscarUsuario(id);
    }

    @GetMapping("/listar-usuarios")
    public List<usuario> listaUsuarios(){
        return usuarioServices.ListarUsuario();
    }

    @DeleteMapping("/deletar-usuario/{id}")
    private String deletarUsuario(@PathVariable Integer id){
        if(usuarioServices.deletarUsuario(id)) {
            return "Usuario removido com sucesso.";
        }
        return "Falha ao re,over usuario.";
    }
    @PostMapping("/salva-usuario")
    public usuario cadastrauUsuario(@RequestBody usuario usuario){
        return usuarioServices.cadastraUsuario(usuario);
    }
    
    @PostMapping("/atualizar-usuario/{id}")
    public String atualizaUsuario(@PathVariable Integer id, @RequestBody usuario usuario){
        if (usuarioServices.atualUsuario(id, usuario)!= null){
            return "Usuario atualizado com sucesso. ";
        }
        return "falha ao atualizar usuario. ";
    }

    
}