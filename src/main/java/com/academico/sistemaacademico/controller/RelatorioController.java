package com.academico.sistemaacademico.controller;

import com.academico.sistemaacademico.model.Matricula;
import com.academico.sistemaacademico.model.Turma;
import com.academico.sistemaacademico.service.MatriculaService;
import com.academico.sistemaacademico.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RelatorioController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/relatorios/turma/{turmaId}")
    public String gerarRelatorioTurma(@PathVariable Long turmaId, Model model) {
        Turma turma = turmaService.buscarTurmaPorId(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        List<Matricula> matriculas = matriculaService.listarMatriculasPorTurma(turmaId);

        model.addAttribute("turma", turma);
        model.addAttribute("alunos", matriculas.stream()
                .map(Matricula::getAluno)
                .toList());

        return "relatorio-turma";
    }
}
