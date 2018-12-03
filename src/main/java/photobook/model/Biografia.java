package photobook.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name="biografia")
public class Biografia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(max=255, message="A biografia deve possuir no máximo {max} caracteres")
	@Column(name="descricao_biografia")
	private String descricaoBiografia;
	
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	private Usuario usuario;
	
	public Biografia(){
		descricaoBiografia = "";
		usuario = new Usuario();
	}

	public Biografia(Integer id, String descricaoBio, Usuario objetoUsuario) {
		this.id = id;
		descricaoBiografia = descricaoBio;
		usuario = objetoUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoBiografia() {
		return descricaoBiografia;
	}

	public void setDescricaoBiografia(String descricao) {
		this.descricaoBiografia = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
}
