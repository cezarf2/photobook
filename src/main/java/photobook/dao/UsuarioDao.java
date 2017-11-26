package photobook.dao;

import java.util.List;

import photobook.model.Usuario;

public interface UsuarioDao {
	
	public void adicionar(Usuario usuario);
	public List<Usuario> getList();
	public Usuario getUsuario(Integer idUsuario);
	public Usuario getUsuario(String username);
	public boolean existeUsuario(Usuario usuario);
	public void remover(Integer idUsuario);
	public void alterar(Usuario usuario);
	
}
