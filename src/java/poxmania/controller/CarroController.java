//Autores: Samuel Martin y Juan Antonio Echeverrias
package poxmania.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import poxmania.dao.CategoriaDAO;
import poxmania.dao.PedidoDAO;
import poxmania.dao.ProductoDAO;
import poxmania.dao.RelacionproductopedidoDAO;
import poxmania.dao.UsuarioDAO;
import poxmania.model.Carro;
import poxmania.model.Categoria;
import poxmania.model.Pedido;
import poxmania.model.Producto;
import poxmania.model.ProductoCarro;
import poxmania.model.Relacionproductopedido;
import poxmania.model.Usuario;

@Controller
public class CarroController {

    @Autowired
    ProductoDAO producto;

    @Autowired
    UsuarioDAO usuDAO;

    @Autowired
    PedidoDAO pedDAO;

    @Autowired
    RelacionproductopedidoDAO relDAO;

    @Autowired
    CategoriaDAO catDAO;

    @RequestMapping(value = "/meterEnCarro", method = RequestMethod.GET)
    public String meterEnCarro(@RequestParam(value = "id") int id, Model model, HttpSession session) {
        Carro carro = (Carro) session.getAttribute("carro");
        Producto prod = producto.get(id);
        ProductoCarro prodcarro = new ProductoCarro(prod, 1);
        carro.meterEnCarro(prodcarro);
        session.setAttribute("carro", carro);
        return "redirect:index";
    }

    @RequestMapping(value = "/sacarDeCarro", method = RequestMethod.GET)
    public String sacarDeCarro(@RequestParam(value = "id") int id, HttpSession session) {
        Carro carro = (Carro) session.getAttribute("carro");
        carro.sacarDeCarro(id);
        session.setAttribute("carro", carro);
        return "verCarro";
    }

    @RequestMapping(value = "/incrementar", method = RequestMethod.GET)
    public String incrementarUnidades(@RequestParam(value = "id") int id, HttpSession session) {
        Carro carro = (Carro) session.getAttribute("carro");
        carro.incrementarUnidades(id, 1);
        session.setAttribute("carro", carro);
        return "redirect:verCarro";
    }

    @RequestMapping(value = "/decrementar", method = RequestMethod.GET)
    public String decrementarUnidades(@RequestParam(value = "id") int id, HttpSession session) {
        Carro carro = (Carro) session.getAttribute("carro");
        carro.decrementarUnidades(id, 1);
        session.setAttribute("carro", carro);
        return "redirect:verCarro";
    }

    @RequestMapping(value = "/verCarro", method = RequestMethod.GET)
    public String verCarro(Model model, HttpSession session) {
        List<Categoria> listaCategorias = null;
        listaCategorias = catDAO.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        model.addAttribute("carro", session.getAttribute("carro"));
        return "verCarro";
    }

    @RequestMapping(value = "/hacerPedido", method = RequestMethod.GET)
    @SuppressWarnings("empty-statement")
    public String hacerPedido(ModelMap model, HttpSession session) {
        Carro carro = (Carro) session.getAttribute("carro");
        String user = (String) session.getAttribute("user");
        int userid = -1;
        Usuario usuario = null;
        if ((user != null) && (user != "")) {
            userid = (int) session.getAttribute("userid");
            usuario = usuDAO.get(userid);
        }
        if ((carro != null) && (!carro.getContenido().isEmpty())) { // si no esta vacio
            if (user != "") {
                model.addAttribute("usuario", usuario);
                return "hacerPedido";
            } else {
                return "loginORegistro";
            }
        } else { //carro vacio
            return "redirect:index";
        }
    }

    @RequestMapping(value = "/pago", method = RequestMethod.GET)
    public String pago(@RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "direccion") String direccion,
            @RequestParam(value = "userid") int userid,
            @RequestParam(value = "option") int tipoPago,
            @RequestParam(value = "telefono") String telefono,
            ModelMap model, HttpSession session) {
        Carro carro = (Carro) session.getAttribute("carro");
        Usuario usuario = usuDAO.get(userid);
        usuario.setDireccion(direccion);
        usuario.setNombre(nombre);
        usuario.setTelefono(telefono);
        usuDAO.update(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("userid", userid);
        if (tipoPago == 1) {
            int u = pagar(usuario, carro);
            model.addAttribute("total", (carro.getPrecio() + 5));
            carro.vaciarCarro();
            session.setAttribute("carro", carro);
            if (u != -1) {
                model.addAttribute("productoAgotado", producto.get(u));
                return "productoAgotado";
            }
            return "finPago";
        } else {
            session.setAttribute("carro", carro);
            return "pagoTarjeta";
        }
    }

    @RequestMapping(value = "/pagoTarjeta", method = RequestMethod.GET)
    public String terminarPedido(@RequestParam(value = "userid") int userid,
            ModelMap model, HttpSession session) {
        Carro carro = (Carro) session.getAttribute("carro");
        Usuario usuario = usuDAO.get(userid);
        int u = pagar(usuario, carro);
        model.addAttribute("total", carro.getPrecio());
        carro.vaciarCarro();
        session.setAttribute("carro", carro);
        if (u != -1) {
            model.addAttribute("productoAgotado", producto.get(u));
            return "productoAgotado";
        }
        return "finPago";
    }

    public int pagar(Usuario u, Carro c) {
        Pedido p = new Pedido(u, c.getPrecio(), "Nuevo");
        for (ProductoCarro productoCarro : c.getContenido()) { // comprobar si hay stock de todo
            Producto prod = productoCarro.getProd();
            if ((prod.getStock() - productoCarro.getCantidad()) < 0) {
                return prod.getIdproducto();
            }
        }
        pedDAO.save(p);
        for (ProductoCarro productoCarro : c.getContenido()) {
            Producto prod = productoCarro.getProd();
            // hay que restar en el stock
            prod.setStock(prod.getStock() - productoCarro.getCantidad());
            producto.update(prod);
            Relacionproductopedido rel = new Relacionproductopedido(p.getIdpedido(), prod.getIdproducto(), productoCarro.getCantidad());
            relDAO.save(rel);
        }
        return -1;
    }

}
