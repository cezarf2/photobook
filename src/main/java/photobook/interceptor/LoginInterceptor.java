package photobook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception{
		String uri = request.getRequestURI();
		if(uri.contains("publicacao/")){
			char uriPublicacao = uri.charAt(uri.length() - 1);
			if(Character.isDigit(uriPublicacao) == true){
				return true;
			}
		}
		if(uri.endsWith("loginForm") || uri.endsWith("loginExecuta")
				|| uri.endsWith("/users/add") || uri.endsWith("newuser")
				|| uri.endsWith("/users/")){
			return true;
		}
		else if(request.getSession().getAttribute("usuarioLogado") != null){
			return true;
		}
		response.sendRedirect("/loginForm");
		return false;
	}
	
}
