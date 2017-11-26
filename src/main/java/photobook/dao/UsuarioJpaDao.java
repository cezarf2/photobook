package photobook.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import photobook.model.Biografia;
import photobook.model.Usuario;
import photobook.repository.UsuarioRepository;

@Repository
@Primary
public class UsuarioJpaDao implements UsuarioDao {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EntityManager entityManager;	

	@Override
	public void adicionar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> getList() {
		return usuarioRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "login")));
	}

	@Override
	public Usuario getUsuario(Integer idUsuario) {
		Usuario usuario = null;
		try{
			usuario = usuarioRepository.findOne(idUsuario);
			Biografia biografia = (Biografia) entityManager.createQuery("select b from biografia b "
					+ "where b.usuario = :usuario")
					.setParameter("usuario", usuario)
					.getSingleResult();
			usuario.setBiografia(biografia);
		}catch(Exception e){
			e.printStackTrace();
		}

		return usuario;
	}

	public Usuario getUsuario(String username){
		Usuario usuario = null; 
		try{
			usuario = (Usuario) entityManager.createQuery("select u from usuario u "
					+ "where u.login = :login")
					.setParameter("login", username)
					.getSingleResult();
			Biografia biografia = (Biografia) entityManager.createQuery("select b from biografia b "
					+ "where b.usuario = :usuario")
					.setParameter("usuario", usuario)
					.getSingleResult();
			usuario.setBiografia(biografia);
		}catch(Exception e){
			e.printStackTrace();
		}

		return usuario;
	}

	public boolean existeUsuario(Usuario usuario) {
		Usuario usuarioLogin = null; 
		try{
			usuarioLogin = (Usuario) entityManager.createQuery("select u from usuario u "
					+ "where u.login = :login and u.senha = :senha")
					.setParameter("login", usuario.getLogin())
					.setParameter("senha", usuario.getSenha())
					.getSingleResult();

		}catch(Exception e){
			e.printStackTrace();
		}

		if(usuarioLogin == null){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public void remover(Integer idUsuario) {
		usuarioRepository.delete(idUsuario);
	}

	@Override
	public void alterar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}	

}