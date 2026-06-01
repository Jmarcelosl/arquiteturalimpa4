package sistema_biblioteca.arq_limpa.application.usecases;

import java.util.List;

import sistema_biblioteca.arq_limpa.application.gateways.LeitorGateway;
import sistema_biblioteca.arq_limpa.domain.Leitor;

public class LeitorUsecase {

    public final LeitorGateway gateway;

    public LeitorUsecase(LeitorGateway gateway) {
        this.gateway = gateway;
    }

    public Leitor cadastrarLeitor(Leitor leitor) {
        return gateway.cadastrarLeitor(leitor);
    }

    public List<Leitor> listarLeitores() {
        return gateway.listarLeitores();
    }

    public void deletarLeitor(Integer id) {
        gateway.deletarLeitor(id);
    }

    public Leitor editarLeitor(Integer id, Leitor leitor) {
        return gateway.editarLeitor(id, leitor);
    }

}
