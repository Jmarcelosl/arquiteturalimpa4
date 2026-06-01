package sistema_biblioteca.arq_limpa.infraestrutura.gateways;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema_biblioteca.arq_limpa.application.gateways.EmprestimoGateway;
import sistema_biblioteca.arq_limpa.domain.Emprestimo;
import sistema_biblioteca.arq_limpa.infraestrutura.mappers.EmprestimoMapper;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.EmprestimoEntity;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.EmprestimoRepository;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.LivroEntity;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.LivroRepository;

@Service
public class EmprestimoServiceGateway implements EmprestimoGateway {

    @Autowired
    EmprestimoRepository repository;

    @Autowired
    LivroRepository livroRepository; // Injetado para gerenciar o estado do livro emprestado

    @Autowired
    EmprestimoMapper mapper;

    @Override
    public void emprestarLivro(Integer idLivro) {
        // Segue a mesma lógica do seu 'updateStatus', buscando a entidade existente
        LivroEntity livroEntity = livroRepository.findById(idLivro)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado com o ID: " + idLivro));

        livroEntity.setIsEmprestado(true);
        livroRepository.save(livroEntity);

        // Se sua lógica exigir salvar um registro histórico na tabela de empréstimos,
        // você pode instanciar e salvar um EmprestimoEntity aqui.
    }

    @Override
    public void devolverLivro(Integer idLivro) {
        LivroEntity livroEntity = livroRepository.findById(idLivro)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado com o ID: " + idLivro));

        livroEntity.setIsEmprestado(false);
        livroRepository.save(livroEntity);
    }

    @Override
    public List<Emprestimo> listarEmprestimos() {
        List<EmprestimoEntity> emprestimos = repository.findAll();
        return emprestimos.stream().map(u -> mapper.toDomain(u)).toList();
    }
}