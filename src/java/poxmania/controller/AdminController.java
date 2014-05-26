//Autores: Samuel Martin y Juan Antonio Echeverrias

package poxmania.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import poxmania.dao.AdminDAO;
import poxmania.model.Administrador;

@Controller
public class AdminController {

        @Autowired
        AdminDAO adminDAO;
    
       
        @RequestMapping(value="/admin", method = RequestMethod.GET) 
	public String registro() {
            return "adminLogin";
	}
        
        @RequestMapping(value="/opcionesAdmin", method = RequestMethod.GET)
	public String opcionesAdmin(@RequestParam(value = "nombre") String nombre, 
           @RequestParam(value = "pass") String pass) {
            List <Administrador> listaAdministradores = adminDAO.findByNombreAdmin(nombre, pass);
            if (!listaAdministradores.isEmpty()){
                return "adminOpciones";
            }
            else{
                return "adminLogin";
            }
	}
       
        @RequestMapping(value="/opcionesAdminOK", method = RequestMethod.GET)
	public String opcionesAdminOK() {
            return "adminOpciones";
	}
 
}