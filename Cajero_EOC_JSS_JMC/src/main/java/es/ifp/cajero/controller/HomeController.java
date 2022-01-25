package es.ifp.cajero.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.ifp.cajero.modelo.beans.Cuenta;
import es.ifp.cajero.modelo.dao.IntCuentaDao;

@Controller
public class HomeController {
	
	@Autowired
	private IntCuentaDao cdao;
	
	@GetMapping("/")
	public String verLogin() {
		return "login";
	}
	
	@GetMapping("/inicio")
	public String verInicio(HttpSession session, Model model) {
		
		return "index";
	}
	
	@PostMapping("/inicio")
	public String procInicio(Integer idCuenta,HttpSession session) {
		Cuenta cuenta=cdao.findOne(idCuenta);
		if(cuenta!=null) { //Si la cuenta existe en la bbdd, te lleva a index.jsp
			session.setAttribute("cuenta", cuenta);//Asignamos a esa sesion el valor de la cuenta introducida por el input
			return"index";
		}else { //Si no, vuelves al login
			return "login";
		}
		
	}
	
	@GetMapping("/logout")
	public String procLogout(Model model,HttpSession session) {
		session.removeAttribute("cuenta");//Eliminamos el atributo cuenta de la sesion
		return "login";
	}
	
	
	

}
