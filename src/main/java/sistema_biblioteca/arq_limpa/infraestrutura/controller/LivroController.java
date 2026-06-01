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

import sistema_biblioteca.arq_limpa.application.usecases.LivroUsecase;
import sistema_biblioteca.arq_limpa.domain.Livro;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroUsecase useCase;

    @PostMapping("/novo")
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return useCase.cadastrarLivro(livro);
    }

    @GetMapping("/lista")
    public List<Livro> listarLivros() {
        return useCase.listarLivros();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarLivro(@PathVariable Integer id) {
        useCase.deletarLivro(id);
    }

    @PutMapping("/editar/{id}")
    public Livro editarLivro(@PathVariable Integer id, @RequestBody Livro livro) {
        return useCase.editarLivro(id, livro);
    }
}