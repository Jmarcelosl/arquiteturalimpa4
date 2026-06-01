package sistema_biblioteca.arq_limpa.infraestrutura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema_biblioteca.arq_limpa.application.usecases.EmprestimoUsecase;
import sistema_biblioteca.arq_limpa.domain.Emprestimo;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    EmprestimoUsecase useCase;

    @PostMapping("/emprestar/{idLivro}")
    public void emprestarLivro(@PathVariable Integer idLivro) {
        useCase.emprestarLivro(idLivro);
    }

    @PostMapping("/devolver/{idLivro}")
    public void devolverLivro(@PathVariable Integer idLivro) {
        useCase.devolverLivro(idLivro);
    }

    @GetMapping("/lista")
    public List<Emprestimo> listarEmprestimos() {
        return useCase.listarEmprestimos();
    }
}