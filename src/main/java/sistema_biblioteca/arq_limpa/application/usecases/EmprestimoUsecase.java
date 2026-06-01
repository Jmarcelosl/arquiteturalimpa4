package sistema_biblioteca.arq_limpa.application.usecases;

import java.util.List;

import sistema_biblioteca.arq_limpa.application.gateways.EmprestimoGateway;
import sistema_biblioteca.arq_limpa.domain.Emprestimo;

public class EmprestimoUsecase {

    public final EmprestimoGateway gateway;

    public EmprestimoUsecase(EmprestimoGateway gateway) {
        this.gateway = gateway;
    }

    public void emprestarLivro(Integer idLivro) {
        gateway.emprestarLivro(idLivro);
    }

    public void devolverLivro(Integer idLivro) {
        gateway.devolverLivro(idLivro);
    }

    public List<Emprestimo> listarEmprestimos() {
        return gateway.listarEmprestimos();
    }

}
