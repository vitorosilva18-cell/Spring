package com.senai.backend.comtrole_frequecia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.comtrole_frequecia.models.Pauta;
import com.senai.backend.comtrole_frequecia.repositories.PautaRepository;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    public Long contarPauta() {
        return pautaRepository.count();
    }

    public Pauta buscarPauta(Integer id) {
        return pautaRepository.findById(id).get();
    }

    public List<Pauta> ListarPauta() {
        return pautaRepository.findAll();
    }

    public Boolean deletarPauta(Integer id) {
        if (pautaRepository.existsById(id)) {
            pautaRepository.deleteById(id);
            return true;
        }

        return false;

    }

    public Pauta cadastrarPauta(Pauta pauta) {
        return pautaRepository.save(pauta);

    }

    public Pauta atualiPauta(Integer id, Pauta pauta) {
        Pauta pautaRecuperada = buscarPauta(id);
        if (pautaRecuperada != null) {
            if (pauta.getTurma() != null) {
                pautaRecuperada.setTurma(pauta.getTurma());
            }
            return pautaRepository.save(pautaRecuperada);
        }
        return null;
    }
}
