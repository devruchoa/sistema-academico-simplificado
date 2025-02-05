package com.academico.sistemaacademico.service;

import com.academico.sistemaacademico.model.Disciplina;
import com.academico.sistemaacademico.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina cadastrarDisciplina(Disciplina disciplina) {
        if (disciplinaRepository.existsByCodigo(disciplina.getCodigo())) {
            throw new RuntimeException("Código da disciplina já existe!");
        }
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizarDisciplina(Long id, Disciplina disciplinaAtualizada) {
        return disciplinaRepository.findById(id)
                .map(disciplina -> {
                    disciplina.setNome(disciplinaAtualizada.getNome());
                    disciplina.setCodigo(disciplinaAtualizada.getCodigo());
                    disciplina.setEmenta(disciplinaAtualizada.getEmenta());
                    disciplina.setCargaHoraria(disciplinaAtualizada.getCargaHoraria());
                    return disciplinaRepository.save(disciplina);
                })
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
    }

    public void deletarDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
