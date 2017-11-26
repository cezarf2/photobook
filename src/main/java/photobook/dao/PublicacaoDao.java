package photobook.dao;

import java.util.List;

import photobook.model.Publicacao;
import photobook.model.Usuario;

public interface PublicacaoDao {
	public void adicionar(Publicacao publicacao);
	public List<Publicacao> getList();
	public List<Publicacao> getPublicacoesUsuario(Usuario usuario);
	public Publicacao getPublicacao(Integer idPublicacao);
	public void remover(Integer idPublicacao);
	public void alterar(Publicacao publicacao);
}
