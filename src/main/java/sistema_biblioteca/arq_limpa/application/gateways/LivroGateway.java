package sistema_biblioteca.arq_limpa.application.gateways;

import java.util.List;

import sistema_biblioteca.arq_limpa.domain.Livro;

public interface LivroGateway {

    Livro cadastrarLivro(Livro livro);

    List<Livro> listarLivros();

    void deletarLivro(Integer id);

    Livro editarLivro(Integer id, Livro livro);

}
