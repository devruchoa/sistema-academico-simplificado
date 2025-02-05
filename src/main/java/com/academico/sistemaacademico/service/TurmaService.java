package com.academico.sistemaacademico.service;

import com.academico.sistemaacademico.model.Turma;
import com.academico.sistemaacademico.repository.TurmaRepository;
import com.academico.sistemaacademico.service.DisciplinaService;
import com.academico.sistemaacademico.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private SemestreService semestreService;

    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarTurmaPorId(Long id) {
        return turmaRepository.findById(id);
    }

    public Turma cadastrarTurma(Turma turma) {
        if (!disciplinaService.buscarDisciplinaPorId(turma.getDisciplina().getId()).isPresent()) {
            throw new RuntimeException("Disciplina não encontrada!");
        }

        if (!semestreService.buscarSemestrePorId(turma.getSemestre().getId()).isPresent()) {
            throw new RuntimeException("Semestre não encontrado!");
        }

        return turmaRepository.save(turma);
    }

    public Turma atualizarTurma(Long id, Turma turmaAtualizada) {
        return turmaRepository.findById(id)
                .map(turma -> {
                    turma.setHorario(turmaAtualizada.getHorario());
                    turma.setProfessor(turmaAtualizada.getProfessor());
                    turma.setDisciplina(turmaAtualizada.getDisciplina());
                    turma.setSemestre(turmaAtualizada.getSemestre());
                    return turmaRepository.save(turma);
                })
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

    public void deletarTurma(Long id) {
        turmaRepository.deleteById(id);
    }
}
