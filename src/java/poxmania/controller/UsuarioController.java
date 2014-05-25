//Autores: Samuel Martin y Juan Antonio Echeverrias

package poxmania.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import poxmania.dao.UsuarioDAO;
import poxmania.model.Usuario;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioDAO daousu;

    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.GET)
    public String registrarUsuario(@RequestParam(value = "first_name") String first_name, 
            @RequestParam(value = "last_name") String last_name, 
            @RequestParam(value = "direccion") String direccion, 
            @RequestParam(value = "telefono") String telefono, 
            @RequestParam(value = "nick") String nick, 
            @RequestParam(value = "password") String password, 
            HttpSession session) {
        String vista = "registro";
        Usuario usuario = daousu.findByNick(nick);
        if (usuario == null) {
            daousu.save(new Usuario(nick, password, first_name + " " + last_name, direccion, telefono));
            session.setAttribute("user", nick);
            vista = "index";
        }
        return vista;
    }

    @RequestMapping(value = "/loginUsuario", method = RequestMethod.GET)
    public String loginUsuario(@RequestParam(value = "nick") String nick, 
            @RequestParam(value = "password") String password, HttpSession session) {
        Usuario usuario = daousu.findByNick(nick);
        if ((usuario != null) && (usuario.getPass().compareTo(password) == 0)) {
            session.setAttribute("user", nick);
            session.setAttribute("userid", usuario.getIdusuario());
        }
        return "redirect:index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpSession session) {
        session.setAttribute("user", "");
        session.setAttribute("userid", -1);
        return "redirect:index";
    }

}
