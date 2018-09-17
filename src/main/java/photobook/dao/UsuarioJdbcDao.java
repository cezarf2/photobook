package photobook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import photobook.model.Biografia;
import photobook.model.Usuario;

@Repository
public class UsuarioJdbcDao implements UsuarioDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Usuario> rowMapper = new RowMapper<Usuario>() {

		@Override
		public Usuario mapRow(ResultSet resultSet, int numberRow) throws SQLException {
			return new Usuario(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4), 
					resultSet.getString(5), (Biografia) resultSet.getObject(6));
		}
	};

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> getList() {
		String querySelect = "select * from usuario";
		return jdbcTemplate.query(querySelect, rowMapper);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario getUsuario(Integer idUsuario) {
		String querySelect = "select * from usuario where id = ?";
		return jdbcTemplate.queryForObject(querySelect, new Object[]{idUsuario}, rowMapper);
	}

	@Override
	@Transactional
	public void adicionar(Usuario usuario) {
		String queryInsert = "insert into usuario(login, nome, senha) values(?, ?, ?)";
		jdbcTemplate.update(queryInsert, new Object[]{
				usuario.getLogin(), usuario.getNome(), usuario.getSenha()
		});
	}

	@Override
	@Transactional
	public void remover(Integer idUsuario) {
		String queryDelete = "delete from usuario where id=?";
		jdbcTemplate.update(queryDelete, new Object[]{idUsuario});
	}

	@Override
	@Transactional
	public void alterar(Usuario usuario) {
		String queryUpdate = "update usuario set login = ?, nome = ?, senha = ? "
				+ "where id = ?";
		jdbcTemplate.update(queryUpdate, new Object[]{
				usuario.getLogin(), usuario.getNome(), usuario.getSenha(), usuario.getId()	
		});
	}

	@Override
	public boolean existeUsuario(Usuario usuario) {
		
		return false;
	}

	@Override
	public Usuario getUsuario(String username) {
		return null;
	}
}
