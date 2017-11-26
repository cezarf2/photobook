package photobook.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import photobook.model.Publicacao;
import photobook.model.Usuario;
import photobook.repository.PublicacaoRepository;

@Repository
@Primary
public class PublicacaoJpaDao implements PublicacaoDao{

	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void adicionar(Publicacao publicacao) {
		publicacaoRepository.save(publicacao);
	}

	@Override
	public List<Publicacao> getList() {
		return publicacaoRepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "id")));
	}

	@Override
	public List<Publicacao> getPublicacoesUsuario(Usuario usuario) {
		List<Publicacao> publicacoesUsuario = new ArrayList<Publicacao>();
		try{
			publicacoesUsuario = entityManager.createQuery("select p from publicacao p "
					+ "where p.usuario = :usuario order by(id) desc")
					.setParameter("usuario", usuario)
					.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}

		return publicacoesUsuario;
	}
	
	@Override
	public Publicacao getPublicacao(Integer idPublicacao) {
		return publicacaoRepository.findOne(idPublicacao);
	}

	@Override
	public void remover(Integer idPublicacao) {
		publicacaoRepository.delete(idPublicacao);	
	}

	@Override
	public void alterar(Publicacao publicacao) {
		publicacaoRepository.save(publicacao);
	}


}
