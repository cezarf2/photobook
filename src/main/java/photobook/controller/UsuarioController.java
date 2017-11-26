package photobook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import photobook.dao.BiografiaDao;
import photobook.dao.PublicacaoDao;
import photobook.dao.UsuarioDao;
import photobook.model.Publicacao;
import photobook.model.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private BiografiaDao biografiaDao;
	
	@Autowired
	private PublicacaoDao publicacaoDao;

	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("listaPublicacoes", publicacaoDao.getList());
		return "index";
	}

	@GetMapping(value="/users/add")
	public String visualizarFormAddUsuario(Model model){
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("acao", "/users/newuser");
		model.addAttribute("tipo_input_senha", "password");
		return "cadastro_usuario";
	}

	@PostMapping(value="/users/newuser")
	public String adicionarUsuario(@Valid Usuario usuario, BindingResult result,
			Model model, RedirectAttributes redirectAttributes, HttpSession session){
		if(result.hasFieldErrors()){
			model.addAttribute("tipo_input_senha", "password");
			return "cadastro_usuario";
		}
		usuarioDao.adicionar(usuario);
		if(usuario.getBiografia() != null){
			usuario.getBiografia().setUsuario(usuario);
			biografiaDao.adicionar(usuario.getBiografia());
		}
		session.setAttribute("usuarioLogado", usuario);
		redirectAttributes.addFlashAttribute("msg", "Usuário adicionado com sucesso");
		return "redirect:/";
	}
	
	@PostMapping(value="/users/{id}/delete")
	public String removerUsuario(@PathVariable(value="id") Integer idUsuario,
			RedirectAttributes redirectAttributes, Usuario usuarioRemocao,
			HttpSession session){
		Usuario usuarioLogado = usuarioDao.getUsuario(idUsuario);
		usuarioRemocao.setLogin(usuarioLogado.getLogin());
		if(usuarioDao.existeUsuario(usuarioRemocao)){
			biografiaDao.remover(usuarioLogado.getBiografia().getId());
			session.invalidate();
			redirectAttributes.addFlashAttribute("msgSucesso", "Perfil removido com sucesso");
			return "redirect:/loginForm";
		}
		else{
			redirectAttributes.addFlashAttribute("msgFalha", "Senha incorreta");
			return "redirect:/users/" + usuarioLogado.getLogin();
		}
	}

	@GetMapping(value="/users/{id}/update")
	public String visualizarFormAlterarUsuario(@PathVariable(value="id") Integer idUsuario,
			Model model){
		model.addAttribute("usuario", usuarioDao.getUsuario(idUsuario));
		model.addAttribute("acao", "/users/update");
		model.addAttribute("tipo_input_senha", "text");
		return "editar_usuario";
	}

	@PostMapping(value="/users/update")
	public String alterarUsuario(@Valid Usuario usuario, BindingResult result,
			RedirectAttributes redirectAttributes){
		if(result.hasFieldErrors()){
			return "editar_usuario";
		}
		usuarioDao.alterar(usuario);
		if(usuario.getBiografia() != null){
			usuario.getBiografia().setUsuario(usuario);
			biografiaDao.alterar(usuario.getBiografia());
		}
		redirectAttributes.addFlashAttribute("msgSucesso", "Usuário editado com sucesso");
		return "redirect:/users/" + usuario.getLogin();
	}

	@GetMapping(value="/users/{login}")
	public String visualizarPerfilUsuario(@PathVariable(value = "login") String username,
			Model model){
		Usuario usuario = usuarioDao.getUsuario(username);
		List<Publicacao> publicacoesUsuario = publicacaoDao.getPublicacoesUsuario(usuario); 
		model.addAttribute("usuario", usuario);
		model.addAttribute("listaPublicacoes", publicacoesUsuario);
		model.addAttribute("usuarioRemocao", new Usuario());
		model.addAttribute("acao", "/users/login");
		return "visualizar_usuario";
	}
	
	@GetMapping(value="/users/")
	public String buscarUsuario(Model model, HttpServletRequest request,
			RedirectAttributes redirectAttributes){
		String username = request.getParameter("username");
		if(usuarioDao.getUsuario(username) != null){
			Usuario usuario = usuarioDao.getUsuario(username);
			List<Publicacao> publicacoesUsuario = publicacaoDao.getPublicacoesUsuario(usuario);
			model.addAttribute("usuario", usuario);
			model.addAttribute("listaPublicacoes", publicacoesUsuario);
			return "visualizar_usuario";
		}
		else{
			redirectAttributes.addFlashAttribute("msgFalha", "Não existe nenhum usuário com esse username.");
			return "redirect:/";
		}
		
	}

}
