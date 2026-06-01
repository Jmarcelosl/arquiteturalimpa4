package sistema_biblioteca.arq_limpa.application.gateways;

import java.util.List;

import sistema_biblioteca.arq_limpa.domain.Leitor;

public interface LeitorGateway {

    Leitor cadastrarLeitor(Leitor leitor);

    List<Leitor> listarLeitores();

    void deletarLeitor(Integer id);

    Leitor editarLeitor(Integer id, Leitor leitor);

}
