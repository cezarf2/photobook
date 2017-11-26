package photobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import photobook.model.Biografia;

@Repository
public interface BiografiaRepository extends JpaRepository<Biografia, Integer>{

}
