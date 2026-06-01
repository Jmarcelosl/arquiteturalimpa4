package sistema_biblioteca.arq_limpa.domain;

public record Livro(
        String titulo,
        String autor,
        int anoPublicacao,
        String editora,
        Boolean isEmprestado) {

}
