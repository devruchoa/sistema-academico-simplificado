package com.academico.sistemaacademico.service;

import com.academico.sistemaacademico.model.Semestre;
import com.academico.sistemaacademico.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    public List<Semestre> listarSemestres() {
        return semestreRepository.findAll();
    }

    public Optional<Semestre> buscarSemestrePorId(Long id) {
        return semestreRepository.findById(id);
    }

    public Semestre cadastrarSemestre(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    public Semestre atualizarSemestre(Long id, Semestre semestreAtualizado) {
        return semestreRepository.findById(id)
                .map(semestre -> {
                    semestre.setAno(semestreAtualizado.getAno());
                    semestre.setSemestre(semestreAtualizado.getSemestre());
                    semestre.setDataInicio(semestreAtualizado.getDataInicio());
                    semestre.setDataTermino(semestreAtualizado.getDataTermino());
                    return semestreRepository.save(semestre);
                })
                .orElseThrow(() -> new RuntimeException("Semestre não encontrado"));
    }

    public void deletarSemestre(Long id) {
        semestreRepository.deleteById(id);
    }
}
