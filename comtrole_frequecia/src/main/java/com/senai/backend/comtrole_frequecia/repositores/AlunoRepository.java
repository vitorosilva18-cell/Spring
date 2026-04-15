package com.senai.backend.comtrole_frequecia.repositores;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.senai.backend.comtrole_frequecia.models.Aluno;

@Repository

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    
} 