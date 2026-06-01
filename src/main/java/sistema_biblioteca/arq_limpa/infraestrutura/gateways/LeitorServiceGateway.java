package sistema_biblioteca.arq_limpa.infraestrutura.gateways;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema_biblioteca.arq_limpa.application.gateways.LeitorGateway;
import sistema_biblioteca.arq_limpa.domain.Leitor;
import sistema_biblioteca.arq_limpa.infraestrutura.mappers.LeitorMapper;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.LeitorEntity;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.LeitorRepository;

@Service
public class LeitorServiceGateway implements LeitorGateway {

    @Autowired
    LeitorRepository repository;

    @Autowired
    LeitorMapper mapper;

    @Override
    public Leitor cadastrarLeitor(Leitor leitor) {
        return mapper.toDomain(repository.save(mapper.toEntity(leitor)));
    }

    @Override
    public List<Leitor> listarLeitores() {
        List<LeitorEntity> leitores = repository.findAll();
        return leitores.stream().map(u -> mapper.toDomain(u)).toList();
    }

    @Override
    public void deletarLeitor(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Leitor editarLeitor(Integer id, Leitor leitor) {
        LeitorEntity entity = mapper.toEntity(leitor);
        entity.setId(id); // Define o ID para garantir a atualização
        return mapper.toDomain(repository.save(entity));
    }
}