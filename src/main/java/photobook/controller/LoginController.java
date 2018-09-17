package photobook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import photobook.dao.UsuarioDao;
import photobook.model.Usuario;

@Controller
public class LoginController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@GetMapping(value="/loginForm")
	public String loginForm(Model model){
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping(value="/loginExecuta")
	public String autenticar(Usuario usuario, HttpSession session,
			Model model, RedirectAttributes redirectAttributes){
		if(usuarioDao.existeUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuarioDao.getUsuario(usuario.getLogin()));
			return "redirect:/";
		}
		else{
			redirectAttributes.addFlashAttribute("msg", "Nome de usuário ou senha inválidos");
			return "redirect:/loginForm";
		}
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/loginForm";
	}
}
