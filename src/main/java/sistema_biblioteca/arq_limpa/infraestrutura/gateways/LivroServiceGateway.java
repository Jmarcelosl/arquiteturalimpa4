package sistema_biblioteca.arq_limpa.infraestrutura.gateways;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema_biblioteca.arq_limpa.application.gateways.LivroGateway;
import sistema_biblioteca.arq_limpa.domain.Livro;
import sistema_biblioteca.arq_limpa.infraestrutura.mappers.LivroMapper;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.LivroEntity;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.LivroRepository;

@Service
public class LivroServiceGateway implements LivroGateway {

    @Autowired
    LivroRepository repository;

    @Autowired
    LivroMapper mapper;

    @Override
    public Livro cadastrarLivro(Livro livro) {
        return mapper.toDomain(repository.save(mapper.toEntity(livro)));
    }

    @Override
    public List<Livro> listarLivros() {
        List<LivroEntity> livros = repository.findAll();
        return livros.stream().map(u -> mapper.toDomain(u)).toList();
    }

    @Override
    public void deletarLivro(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Livro editarLivro(Integer id, Livro livro) {
        LivroEntity entity = mapper.toEntity(livro);
        entity.setId(id); // Define o ID para garantir a atualização
        return mapper.toDomain(repository.save(entity));
    }
}