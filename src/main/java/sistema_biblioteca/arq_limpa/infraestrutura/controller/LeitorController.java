package sistema_biblioteca.arq_limpa.infraestrutura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema_biblioteca.arq_limpa.application.usecases.LeitorUsecase;
import sistema_biblioteca.arq_limpa.domain.Leitor;

@RestController
@RequestMapping("/leitor")
public class LeitorController {

    @Autowired
    LeitorUsecase useCase;

    @PostMapping("/novo")
    public Leitor cadastrarLeitor(@RequestBody Leitor leitor) {
        return useCase.cadastrarLeitor(leitor);
    }

    @GetMapping("/lista")
    public List<Leitor> listarLeitores() {
        return useCase.listarLeitores();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarLeitor(@PathVariable Integer id) {
        useCase.deletarLeitor(id);
    }

    @PutMapping("/editar/{id}")
    public Leitor editarLeitor(@PathVariable Integer id, @RequestBody Leitor leitor) {
        return useCase.editarLeitor(id, leitor);
    }
}