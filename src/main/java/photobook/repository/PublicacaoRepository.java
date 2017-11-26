package photobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import photobook.model.Publicacao;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer>{
	
}
