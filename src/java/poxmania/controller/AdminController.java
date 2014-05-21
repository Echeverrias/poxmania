package poxmania.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import poxmania.dao.AdminDAO;
import poxmania.dao.ProductoDAO;
import poxmania.model.Administrador;

@Controller
public class AdminController {

        @Autowired
        AdminDAO adminDAO;
    
        @RequestMapping(value="/admin", method = RequestMethod.GET)
	public String registro(ModelMap model) {
            return "adminLogin";
	}
        
        @RequestMapping(value="/opcionesAdmin", method = RequestMethod.GET)
	public String opcionesAdmin(@RequestParam(value = "nombre") String nombre, 
           @RequestParam(value = "pass") String pass, ModelMap model) {
            // comprobar contraseña con un dao
            List <Administrador> listaAdministradores = adminDAO.findByNombreAdmin(nombre, pass);
            if (!listaAdministradores.isEmpty()){
                return "adminOpciones";
            }
            else{
                return "adminLogin";
            }
            
	
	}
        
        @RequestMapping(value="/opcionesAdminOK", method = RequestMethod.GET)
	public String opcionesAdminOK(ModelMap model) {
            return "adminOpciones";
	}
        
        
        

}