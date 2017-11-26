package photobook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="usuario")
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=3, max=50, message="O nome deve possuir entre {min} e {max} letras")
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	@Size(min=5, max=10, message="O login deve possuir entre {min} e {max} caracteres")
	private String login;
	
	@NotNull
	@Size(min=5, max=10, message="A senha deve possuir entre {min} e {max} caracteres")
	private String senha;
	
	@Transient
	@OneToOne(mappedBy="biografia")
	private Biografia biografia;

	public Usuario(Integer id, String nomeUsuario, String emailUsuario, String loginUsuario,
			String senhaUsuario, Biografia biografia) {
		this.id = id;
		nome = nomeUsuario;
		email = emailUsuario;
		login = loginUsuario;
		senha = senhaUsuario;
		this.biografia = biografia;
	}
	
	public Usuario(){
		nome = "";
		email = "";
		login = "";
		senha = "";
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

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Biografia getBiografia(){
		return this.biografia;
	}
	
	public void setBiografia(Biografia biografia){
		this.biografia = biografia;
	}

}
