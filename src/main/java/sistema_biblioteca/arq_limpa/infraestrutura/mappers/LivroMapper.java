package sistema_biblioteca.arq_limpa.infraestrutura.mappers;

import org.springframework.stereotype.Component;

import sistema_biblioteca.arq_limpa.domain.Livro;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.LivroEntity;

@Component
public class LivroMapper {

    public LivroEntity toEntity(Livro livro) {
        return new LivroEntity(
                livro.titulo(),
                livro.autor(),
                livro.anoPublicacao(),
                livro.editora(),
                livro.isEmprestado());
    }

    public Livro toDomain(LivroEntity entity) {
        return new Livro(
                entity.getTitulo(),
                entity.getAutor(),
                entity.getAnoPublicacao(),
                entity.getEditora(),
                entity.getIsEmprestado());
    }

}