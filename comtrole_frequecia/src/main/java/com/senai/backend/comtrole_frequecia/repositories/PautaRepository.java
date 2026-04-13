package com.senai.backend.comtrole_frequecia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.backend.comtrole_frequecia.models.Pauta;

@Repository
public interface PautaRepository extends JpaRepository <Pauta, Integer> {
    
}
