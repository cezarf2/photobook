package photobook.dao;

import java.util.List;

import photobook.model.Biografia;

public interface BiografiaDao {
	public void adicionar(Biografia biografia);
	public List<Biografia> getList();
	public Biografia getBiografia(Integer idBiografia);
	public void remover(Integer idBiografia);
	public void alterar(Biografia biografia);
	
}
