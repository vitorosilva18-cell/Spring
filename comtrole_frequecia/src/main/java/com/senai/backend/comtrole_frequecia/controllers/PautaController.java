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

import com.senai.backend.comtrole_frequecia.models.Pauta;
import com.senai.backend.comtrole_frequecia.services.PautaService;



@RestController
@RequestMapping("/Pauta")
 public class PautaController {

    @Autowired
    private PautaService paPautaService;

    @GetMapping("/contar-pauta")
    public Long contarPautas(){
        return paPautaService.contarPauta();
    }

    @GetMapping("/buscar-pauta/{id}")
    public Pauta buscarPauta(@PathVariable Integer id){
        return paPautaService.buscarPauta(id);
    }

    @GetMapping("/listar-pauta")
    public List<Pauta> listaPautas(){
        return paPautaService.ListarPauta();
    }

    @DeleteMapping("/deletar-pauta/{id}")
    public String deletarPauta(@PathVariable Integer id){
        if (paPautaService.deletarPauta(id)){
            return "Pauta removida com sucesso. ";
        }
        return "Falha ao remover pauta. ";
    }

    @PostMapping("/salvar-pauta")
    public Pauta cadastrPauta(@RequestBody Pauta pauta){
        return paPautaService.cadastrarPauta(pauta);
    }

    @PostMapping("/atualiza-pauta")
        public String atualizarPauta(@PathVariable Integer id, @RequestBody Pauta pauta){
            if (paPautaService.atualiPauta(id, pauta)!= null) {
                return "Pauta atualizada com sucesso. ";
                
            }
            return "Falha ao atualizar pauta. ";
            
        }
    }
    
