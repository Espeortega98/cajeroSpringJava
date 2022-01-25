package es.ifp.cajero.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.ifp.cajero.modelo.beans.Cuenta;
import es.ifp.cajero.modelo.beans.Movimiento;
import es.ifp.cajero.modelo.dao.IntCuentaDao;
import es.ifp.cajero.modelo.dao.IntMovimientoDao;

@Controller
@RequestMapping("/cuenta")
public class CuentaController {
	@Autowired
	private IntCuentaDao cdao;
	
	@Autowired
	private IntMovimientoDao mdao;
	
	//EXTRAER
	
		@GetMapping("/extraer")
		public String mostrarExtraer(HttpSession session, Model model) {
			return "extraccion"; 
		}
		
		@PostMapping("/extraer")
		public String procExtraer(Double cantidad,HttpSession session, Model model) {
			Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
			cuenta.extraerSaldo(cantidad);
			cdao.modificarUna(cuenta);//Para hacer update, una vez hemos modificado la cantidad con el metodo extraerSaldo()
			
			Movimiento movi = new Movimiento();
			
			movi.setFecha(new Date());
			movi.setOperacion("Extraccion"); //Tipo de operacion que hemos realizado. (String)
			movi.setCantidad(cantidad);
			movi.setCuenta(cuenta);
			
			mdao.insertOne(movi); //Insertamos el movimiento con las variables asignadas
			
			return "index";
		}
		
		
		
	
	
	//INGRESAR
	
	@GetMapping("/ingresar")
	public String mostrarIngresar(HttpSession session, Model model) {
		return "ingreso";
	}
	
	@PostMapping("/ingresar")
	public String procIngresar(Double cantidad, HttpSession session, Model model) {
		Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
		cuenta.ingresarSaldo(cantidad);
		cdao.modificarUna(cuenta);
		
		Movimiento movi = new Movimiento();
		
		movi.setFecha(new Date());
		movi.setOperacion("Ingreso");
		movi.setCantidad(cantidad);
		movi.setCuenta(cuenta);
		
		mdao.insertOne(movi);
		
		
		return "index";
	}
	
	
	
	//VER LOS MOVIMIENTOS
	@GetMapping("/movimientos")
	public String verMovimientos(HttpSession session, Model model) {
		Cuenta cuenta = (Cuenta) session.getAttribute("cuenta"); //Cogemos la cuenta correspondiente con session.getAtribute
		List<Movimiento> movimientos = mdao.findByCuenta(cuenta.getIdCuenta()); //Mostramos todos los movimientos de esa cuenta
		model.addAttribute("movimientos",movimientos); //asignamos a model la lista de movimientos para recorrerlos en movimientos.jsp
		
		return "movimientos";
		
	}
	
	
	
	//TRANSFERENCIA
	@GetMapping("/transferencia")
	public String mostrarTransferencia(HttpSession session, Model model) {
		return "transferencia";
	}
	
	@PostMapping("/transferencia")
	public String procTransferencia(Double cantidad, Integer destino, HttpSession session, Model model) {
		Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
		
		Cuenta cuentaDestino = cdao.findOne(destino);
		
		cuenta.extraerSaldo(cantidad); //Usamos extraerSaldo() en la cuenta origen para extraer la cantidad correspondiente
		cuentaDestino.ingresarSaldo(cantidad);//Usamos ingresarSaldo() en la cuenta destino para ingresar la cantidad 
		
		//Hacemos update de cada una de las cuentas --> Destino y origen
		cdao.modificarUna(cuenta);
		cdao.modificarUna(cuentaDestino);
		
		Movimiento movi = new Movimiento();
		
		//Insertamos el nuevo movimiento con cada uno de los campos (Fecha, tipo y cantidad)
		movi.setFecha(new Date());
		movi.setOperacion("Extraccion");
		movi.setCantidad(cantidad);
		movi.setCuenta(cuenta);
		
		mdao.insertOne(movi);
		
		
		Movimiento movi2 = new Movimiento();
		
		movi2.setFecha(new Date());
		movi2.setOperacion("Ingreso");
		movi2.setCantidad(cantidad);
		movi2.setCuenta(cuentaDestino);
		
		mdao.insertOne(movi2);
		
		return "index";
		
	}
	
}
