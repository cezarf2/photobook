package photobook.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import photobook.model.Biografia;
import photobook.repository.BiografiaRepository;

@Repository
@Primary
public class BiografiaJpaDao implements BiografiaDao{

	@Autowired
	private BiografiaRepository biografiaRepository;
	
	@Override
	public void adicionar(Biografia biografia) {
		biografiaRepository.save(biografia);	
	}
	
	@Override
	public List<Biografia> getList() {
		return biografiaRepository.findAll();
	}

	@Override
	public Biografia getBiografia(Integer idBiografia) {
		return biografiaRepository.findOne(idBiografia);
	}

	@Override
	public void remover(Integer idBiografia) {
		biografiaRepository.delete(idBiografia);
	}

	@Override
	public void alterar(Biografia biografia) {
		biografiaRepository.save(biografia);
	}

}
