//Autores: Samuel Martin y Juan Antonio Echeverrias

package poxmania.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import poxmania.dao.PedidoDAO;
import poxmania.dao.ProductoDAO;
import poxmania.dao.RelacionproductopedidoDAO;
import poxmania.dao.UsuarioDAO;
import poxmania.model.Pedido;
import poxmania.model.PedidoConProductos;
import poxmania.model.ProductoCarro;
import poxmania.model.Relacionproductopedido;
import poxmania.model.Usuario;

@Controller
public class PedidoController {
    
    @Autowired
    PedidoDAO daoPed;
    
    @Autowired
    RelacionproductopedidoDAO daoRel;
    
    @Autowired
    ProductoDAO daoProd;
    
    @Autowired
    UsuarioDAO usuDAO;
            
        @RequestMapping(value="/editarPedidos", method = RequestMethod.GET)
	public String editarPedidos(ModelMap model) {
            List <Pedido> listaPedidos = daoPed.findAll();
            List <PedidoConProductos> listaFinal = new ArrayList <PedidoConProductos>();
            for(Pedido ped:listaPedidos){
                List <Relacionproductopedido> listaRelacion = daoRel.findByIdPedido(ped.getIdpedido());
                List <ProductoCarro> listaPC = new ArrayList <ProductoCarro>();
                for(Relacionproductopedido rel:listaRelacion){
                    listaPC.add(new ProductoCarro(rel.getProducto(),rel.getCantidad()));
                }
                listaFinal.add(new PedidoConProductos(ped, listaPC));
            }
            model.addAttribute("listaPedidos", listaFinal);
            return "editarPedidos";
	}
                
        @RequestMapping(value="/editarPedidoConcreto", method = RequestMethod.GET)
	public String editarPedidoConcreto(@RequestParam(value = "idpedido") int idpedido,
                @RequestParam(value = "estado") String estado) {
            Pedido ped = daoPed.get(idpedido);
            ped.setEstado(estado);
            daoPed.update(ped);
            return "redirect:editarPedidos";
	}
        
        @RequestMapping(value="/verMisPedidos", method = RequestMethod.GET)
	public String verMisPedidos(@RequestParam(value = "uId") int uId,
                ModelMap model) {
            Usuario usuario = usuDAO.get(uId);
            List <Pedido> listaPedidos = daoPed.findByUsuario(usuario);
            List <PedidoConProductos> listaFinal = new ArrayList <PedidoConProductos>();
            for(Pedido ped:listaPedidos){
                List <Relacionproductopedido> listaRelacion = daoRel.findByIdPedido(ped.getIdpedido());
                List <ProductoCarro> listaPC = new ArrayList <ProductoCarro>();
                for(Relacionproductopedido rel:listaRelacion){
                    listaPC.add(new ProductoCarro(rel.getProducto(),rel.getCantidad()));
                }
                listaFinal.add(new PedidoConProductos(ped, listaPC));
            }
            model.addAttribute("listaPedidos", listaFinal);
            model.addAttribute("usuarioPedido", usuDAO.get(uId));
            return "verMisPedidos";
	}
    
}
