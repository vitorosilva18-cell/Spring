package com.senai.backend.comtrole_frequecia.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.comtrole_frequecia.models.Turma;
import com.senai.backend.comtrole_frequecia.repositores.TurmaRepository;

@Service
public class TurmaService{ 
    
    @Autowired
    private TurmaRepository turmaRepository;

    public long contarTurma() {
        return turmaRepository.count();   
    
    }

    public Turma buscarTurma(Integer id) {
        return turmaRepository.findById(id).get();
    
    }

    public List<Turma> ListarTurma(){
        return turmaRepository.findAll();
    
    }
    

    public Boolean deletarturma(Integer id){
        if (turmaRepository.existsById(id)){
            turmaRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Turma cadastraTurma(Turma turma){
        return turmaRepository.save(turma);
    }

    public Turma atualiTurma(Integer id, Turma turma){
        Turma turmaRecuperada = buscarTurma(id);
        if (turmaRecuperada != null){
            if (turma.getNome() != null) {
                turmaRecuperada.setNome(turma.getNome());
                
            }
            return turmaRepository.save(turmaRecuperada);
        }
        return null;
    }
}

    
