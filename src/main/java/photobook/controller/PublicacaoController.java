package photobook.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import photobook.dao.PublicacaoDao;
import photobook.model.Publicacao;
import photobook.model.Usuario;
import photobook.service.ImageService;

@Controller
public class PublicacaoController {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private PublicacaoDao publicacaoDao;
	
	@GetMapping(value="/publicacao/add")
	public String visualizarFormPublicacao(Model model){
		model.addAttribute("publicacao", new Publicacao());
		model.addAttribute("acao", "/photobook/publicacao/newpublicacao");
		return "adicionar_publicacao";
	}
	
	@PostMapping(value="/publicacao/newpublicacao")
	public String adicionarPublicacao(@Valid Publicacao publicacao, BindingResult result,
			HttpSession session, HttpServletRequest request, @RequestParam("imagem") MultipartFile nomeImagem){
		if(result.hasFieldErrors()){
			return "adicionar_publicacao";
		}
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		publicacao.setUsuario(usuario);
		publicacao.setNome(nomeImagem.getOriginalFilename());
		String pathFolder = "temp/img/";
		publicacao.setCaminhoImagem(pathFolder + publicacao.getNome());
		String path = request.getServletContext().getRealPath("/") + pathFolder + publicacao.getNome();
		
		try{
			imageService.saveImage(nomeImagem, path);
			publicacaoDao.adicionar(publicacao);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	@GetMapping(value="/publicacao/{id}")
	public String buscarPublicacao(@PathVariable(value="id") Integer idPublicacao,
			Model model){
		Publicacao publicacao = publicacaoDao.getPublicacao(idPublicacao);
		model.addAttribute("publicacaoAtual", publicacao);
		model.addAttribute("usuarioPublicacao", publicacao.getUsuario());
		return "visualizar_publicacao";
	}
	
	@GetMapping(value="/publicacao/{id}/update")
	public String visualizarFormAlterarPublicacao(@PathVariable(value="id") Integer idPublicacao,
			Model model){
		model.addAttribute("publicacao", publicacaoDao.getPublicacao(idPublicacao));
		model.addAttribute("acao", "/photobook/publicacao/update");
		return "editar_publicacao";
	}
	
	@PostMapping(value="/publicacao/update")
	public String editarPublicacao(@Valid Publicacao publicacao, BindingResult result,
			RedirectAttributes redirectAttributes){
		if(result.hasFieldErrors()){
			return "editar_publicacao";
		}
		publicacaoDao.alterar(publicacao);
		redirectAttributes.addFlashAttribute("msgSucesso", "Publicação editada com sucesso.");
		return "redirect:/publicacao/" + publicacao.getId();
	}
	
	@GetMapping(value="/publicacao/{id}/delete")
	public String removerPublicacao(@PathVariable(value="id") Integer idPublicacao,
			RedirectAttributes redirectAttributes, HttpServletRequest request){
		Publicacao publicacao = publicacaoDao.getPublicacao(idPublicacao);
		String pathFolder = "temp/img/";
		String path = request.getServletContext().getRealPath("/") + pathFolder + publicacao.getNome();
		try{
			imageService.deleteImage(path);
			publicacaoDao.remover(idPublicacao);
			redirectAttributes.addFlashAttribute("msgSucesso", "Publicação removida com sucesso.");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/users/" + publicacao.getUsuario().getLogin();
	}
	
}
