package com.senai.backend.comtrole_frequecia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.comtrole_frequecia.models.Aluno;
import com.senai.backend.comtrole_frequecia.repositores.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Long contarAluno() {
        return alunoRepository.count();

    }

    public Aluno buscarAluno(Integer id) {
        return alunoRepository.findById(id).get();
    }

    public List<Aluno> ListarAluno() {
        return alunoRepository.findAll();
    }

    public Boolean deletaAluno(Integer id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Aluno cadastrAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
}
