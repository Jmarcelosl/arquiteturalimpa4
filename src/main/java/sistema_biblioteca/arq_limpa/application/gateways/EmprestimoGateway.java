package sistema_biblioteca.arq_limpa.application.gateways;

import java.util.List;

import sistema_biblioteca.arq_limpa.domain.Emprestimo;

public interface EmprestimoGateway {

    void emprestarLivro(Integer idLivro);

    void devolverLivro(Integer idLivro);

    List<Emprestimo> listarEmprestimos();

}
