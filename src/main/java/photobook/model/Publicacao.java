package photobook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="publicacao")
public class Publicacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="A imagem é um campo obrigatório")
	@Column(name="nome_imagem")
	private String nome;
	
	@Column(name="caminho_imagem")
	private String caminhoImagem;
	
	@NotNull
	@Size(max=255, message="A legenda não pode execeder o máximo de {max} caracteres")
	private String legenda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Publicacao(){
		nome = "";
		legenda = "";
	}
	
	public Publicacao(Integer id, String nomeImagem, String pathImagem, String legendaImagem,
			Usuario objetoUsuario) {
		this.id = id;
		nome = nomeImagem;
		caminhoImagem = pathImagem;
		legenda = legendaImagem;
		usuario = objetoUsuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeImagem) {
		this.nome = nomeImagem;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

}
