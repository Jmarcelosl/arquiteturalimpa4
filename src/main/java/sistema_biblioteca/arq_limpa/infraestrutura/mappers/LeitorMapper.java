package sistema_biblioteca.arq_limpa.infraestrutura.mappers;

import org.springframework.stereotype.Component;

import sistema_biblioteca.arq_limpa.domain.Leitor;
import sistema_biblioteca.arq_limpa.infraestrutura.persistence.LeitorEntity;

@Component
public class LeitorMapper {

    public LeitorEntity toEntity(Leitor leitor) {
        return new LeitorEntity(
                leitor.nome(),
                leitor.idade(),
                leitor.cpf(),
                leitor.email());
    }

    public Leitor toDomain(LeitorEntity entity) {
        return new Leitor(
                entity.getNome(),
                entity.getIdade(),
                entity.getCpf(),
                entity.getEmail());
    }

}