package sistema_biblioteca.arq_limpa.infraestrutura.mappers;

import org.springframework.stereotype.Component;

import sistema_biblioteca.arq_limpa.domain.Emprestimo;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.EmprestimoEntity;

@Component
public class EmprestimoMapper {

    public EmprestimoEntity toEntity(Emprestimo emprestimo) {
        return new EmprestimoEntity(
                emprestimo.leitor(),
                emprestimo.livro(),
                emprestimo.dataEmprestimo(),
                emprestimo.dataDevolucao());
    }

    public Emprestimo toDomain(EmprestimoEntity entity) {
        return new Emprestimo(
                entity.getLeitor(),
                entity.getLivro(),
                entity.getDataEmprestimo(),
                entity.getDataDevolucao());
    }

}