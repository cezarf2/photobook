package photobook;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import photobook.model.Biografia;
import photobook.model.Usuario;
import photobook.repository.BiografiaRepository;
import photobook.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BiografiaRepository biografiaRepository;
	
	@Test
	public void verificaBuscarUsuarioByLogin(){
		Usuario usuario = new Usuario();
		usuario.setLogin("user");
		
		Usuario usuarioEncontrado = usuarioRepository.findByLogin(usuario.getLogin());
		assertThat(usuarioEncontrado.getLogin()).isEqualTo(usuario.getLogin());
	}
	
	@Test
	public void verificaBuscarUsuarioByNome(){
		Usuario usuario = new Usuario();
		usuario.setNome("User");
		
		Usuario usuarioEncontrado = usuarioRepository.findByNome(usuario.getNome());
		assertThat(usuarioEncontrado.getNome()).isEqualTo(usuario.getNome());
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void verificaSalvarUsuarioComNomeMenorQueTresCaracteres(){
		Usuario usuario = new Usuario();
		usuario.setNome("An");
		usuario.setSenha("an123");
		usuario.setLogin("anamaria");
		usuario.setEmail("anamaria@email.com");
		
		usuarioRepository.save(usuario);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void verificaSalvarUsuarioComLoginMenorQueCinco(){
		Usuario usuario = new Usuario();
		usuario.setNome("Ana Maria");
		usuario.setSenha("ana123");
		usuario.setLogin("ana");
		usuario.setEmail("anamaria@email.com");
		
		usuarioRepository.save(usuario);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void verificaSalvarUsuarioComSenhaMenorQueCinco(){
		Usuario usuario = new Usuario();
		usuario.setNome("Ana Maria");
		usuario.setSenha("ana");
		usuario.setLogin("anamaria");
		usuario.setEmail("anamaria@email.com");
		
		usuarioRepository.save(usuario);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void verificaSalvarUsuarioComBiografiaMaiorQue255Caracteres(){
		Usuario usuario = new Usuario();
		usuario.setNome("Ana Maria");
		usuario.setSenha("ana123");
		usuario.setLogin("anamaria");
		usuario.setEmail("anamaria@email.com");
		
		Biografia biografiaDoUsuario = new Biografia();
		biografiaDoUsuario.setDescricaoBiografia("Lorem ipsum urna nulla pellentesque mollis purus"
				+ " aliquam commodo neque etiam aliquam amet, inceptos consequat bibendum pulvinar"
				+ " non fusce aliquam ligula curae tristique mi bibendum, consequat condimentum "
				+ "cubilia sagittis mi auctor rutrum facilisis at litora aenean. eleifend vulputate"
				+ " aliquam odio vivamus curae netus sagittis gravida, a est litora pellentesque eget "
				+ "tempus inceptos scelerisque curae, vel felis ac nec etiam sociosqu vel. sodales tellus"
				+ " netus integer inceptos ligula sagittis nibh primis ullamcorper litora, curae fames massa"
				+ " enim morbi ullamcorper ut morbi aenean, pretium convallis sit tristique interdum urna dictumst"
				+ " quam ad. Vitae enim nam tellus vitae ultricies pellentesque egestas non, mi at suspendisse faucibus"
				+ " neque litora justo. curae ante etiam lacinia vitae libero suspendisse neque sociosqu habitant, nec"
				+ " duis sodales convallis ullamcorper nulla nisl quis netus rhoncus, curabitur lectus non suscipit"
				+ " justo sodales aliquam condimentum. consectetur porttitor etiam interdum fringilla viverra sed neque"
				+ " donec curabitur risus, tempus hac ut cursus blandit felis aenean consequat pretium fusce felis, "
				+ "metus curabitur eu lorem duis in blandit sed nunc. eu hendrerit pharetra taciti turpis nostra non"
				+ " turpis nibh fames morbi suspendisse donec dapibus pulvinar orci, tincidunt justo iaculis senectus"
				+ " etiam nibh mi bibendum pretium sociosqu integer velit mattis ultricies.Dapibus tristique purus"
				+ " viverra tellus aliquam potenti nam ipsum, vivamus vestibulum fringilla taciti lacinia dictumst"
				+ " nostra donec, massa amet in eleifend imperdiet mauris dui. est congue quam hac taciti adipiscing"
				+ " libero nisi sit augue, suspendisse accumsan nisi sem primis pretium nisl magna condimentum, luctus"
				+ " vitae suspendisse nec lacus aenean quis tempus. felis ante aenean eget venenatis vivamus feugiat"
				+ " litora bibendum, semper suspendisse a consectetur ante amet a amet, feugiat aliquam in praesent"
				+ " lacus phasellus aenean.");
	
		biografiaDoUsuario.setUsuario(usuario);
		biografiaRepository.save(biografiaDoUsuario);
		
		usuario.setBiografia(biografiaDoUsuario);
		usuarioRepository.save(usuario);
	}
	
}
