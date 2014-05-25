//Autores: Samuel Martin y Juan Antonio Echeverrias

package poxmania.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import poxmania.dao.CategoriaDAO;
import poxmania.dao.ProductoDAO;
import poxmania.model.Carro;
import poxmania.model.Categoria;
import poxmania.model.Producto;

@Controller
public class IndexController {
    
        @Autowired
        ProductoDAO daoProd;
        
        @Autowired
        CategoriaDAO daoCat;

        @RequestMapping(value="*", method = RequestMethod.GET)
	public String indexDefault() {
	return "redirect:index";
	}
 
        @RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(ModelMap model,HttpSession session) {
        List <Producto> listaProductos = null;
        if (session.isNew()){ //si la sesión es nueva, creamos una variable carro a null y la guardamos en la sesión
             Carro carro = new Carro();
             session.setAttribute("carro",carro);
             session.setAttribute("user","");
             listaProductos = daoProd.findAll();
             session.setAttribute("listaproductos", listaProductos);
        }    
        List <Categoria> listaCategorias = null;
        listaCategorias = daoCat.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "index";
	}
        
        @RequestMapping(value="/indexTodas", method = RequestMethod.GET)
	public String indexTodas(ModelMap model, HttpSession session) {
        List <Producto> listaProductos = null;
        listaProductos = daoProd.findAll();
        List <Categoria> listaCategorias = null;
        listaCategorias = daoCat.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        session.setAttribute("listaproductos", listaProductos);
        return "index";
	}
        
        @RequestMapping(value="/indexEspecifico", method = RequestMethod.GET)
	public String indexEspecifico(@RequestParam (value = "cat", required = false, defaultValue= "1")int categ, ModelMap model, HttpSession session) {
        List <Producto> listaProductos = null;
        Categoria categoria = daoCat.get(categ);
        listaProductos = daoProd.findByCategoria(categoria);
        List <Categoria> listaCategorias = null;
        listaCategorias = daoCat.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        session.setAttribute("listaproductos", listaProductos);
        return "index";
	}
                
        @RequestMapping(value="/registro", method = RequestMethod.GET)
	public String registro(ModelMap model) {
        model.addAttribute("aceptar", "/images/Aceptar.jpg");
	return "registro";
	}
                
        @RequestMapping(value="/detallesProducto", method = RequestMethod.GET)
	public String detallesProducto(@RequestParam (value = "id") int id,ModelMap model) {
            Producto producto = daoProd.get(id);
            List <Categoria> listaCategorias = null;
            listaCategorias = daoCat.findAll();
            model.addAttribute("listaCategorias", listaCategorias);
            model.addAttribute("prod",producto);
	return "detallesProducto";
	}
               
}