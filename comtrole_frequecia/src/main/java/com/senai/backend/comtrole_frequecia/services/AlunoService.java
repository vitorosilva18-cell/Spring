package com.senai.backend.comtrole_frequecia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Long contarAluno() {
        return alunoRepository.count();

    }

    public aluno buscarAluno(Integer id) {
        return alunoRepository.findById(id).get();
    }

    public List<aluno> ListarAluno() {
        return alunoRepository.findAll();
    }

    public Boolean deletaAluno(Integer id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deletaAluno(id);
            return true;
        }
        return false;
    }

    public Aluno cadastrAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
}
