package sistema_biblioteca.arq_limpa.application.usecases;

import java.util.List;

import sistema_biblioteca.arq_limpa.application.gateways.LivroGateway;
import sistema_biblioteca.arq_limpa.domain.Livro;

public class LivroUsecase {

    public final LivroGateway gateway;

    public LivroUsecase(LivroGateway gateway) {
        this.gateway = gateway;
    }

    public Livro cadastrarLivro(Livro livro) {
        return gateway.cadastrarLivro(livro);
    }

    public List<Livro> listarLivros() {
        return gateway.listarLivros();
    }

    public void deletarLivro(Integer id) {
        gateway.deletarLivro(id);
    }

    public Livro editarLivro(Integer id, Livro livro) {
        return gateway.editarLivro(id, livro);
    }

}
