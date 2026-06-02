package sistema_biblioteca.arq_limpa.infraestrutura.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitorRepository extends JpaRepository<LeitorEntity, Integer> {

}