package sistema_biblioteca.arq_limpa.domain;

import java.sql.Date;

public record Emprestimo(
        String leitor,
        String livro,
        Date dataEmprestimo,
        Date dataDevolucao) {

}
