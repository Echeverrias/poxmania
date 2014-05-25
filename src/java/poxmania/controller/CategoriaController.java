//Autores: Samuel Martin y Juan Antonio Echeverrias

package poxmania.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import poxmania.dao.CategoriaDAO;
import poxmania.dao.ProductoDAO;
import poxmania.model.Categoria;
import poxmania.model.Producto;

@Controller
public class CategoriaController {
        @Autowired
        CategoriaDAO daoCat;
        
        @Autowired
        ProductoDAO daoProd;
    
        @RequestMapping(value="/nuevaCategoria", method = RequestMethod.GET)
	public String nuevaCategoria(ModelMap model) {
            return "nuevaCategoria";
	}
        
        @RequestMapping(value="/insertarCategoria", method = RequestMethod.GET)
	public String insertarCategoria(@RequestParam(value = "nombreCategoria") String nombreCategoria) {
            Categoria cat = new Categoria(nombreCategoria);
            daoCat.save(cat);
            return "adminOpciones";
	}
        
        @RequestMapping(value="/editarCategoria", method = RequestMethod.GET)
	public String editarCategoria(ModelMap model) {
            List <Categoria> listaCategorias = null;
            listaCategorias = daoCat.findAll();
            model.addAttribute("listaCategorias", listaCategorias);
            return "elegirCategoria";
	}
        
        @RequestMapping(value="/editarCategoriaConcreta", method = RequestMethod.GET)
	public String editarCategoriaConcreta (@RequestParam (value = "id", required = false, defaultValue= "1")int idCat, ModelMap model) {
            Categoria categoria = daoCat.get(idCat);
            model.addAttribute("categoria", categoria);
            return "editarCategoria";
	}
        
        @RequestMapping(value="/editarCategoriaFin", method = RequestMethod.GET)
	public String editarCategoriaFin(@RequestParam(value = "nombreCategoria") String nombreCategoria, 
                @RequestParam(value = "idcategoria") int idCategoria) {
            Categoria categoria = daoCat.get(idCategoria);
            categoria.setNombrecategoria(nombreCategoria);
            daoCat.update(categoria);
            return "adminOpciones";
	}
        
        
        @RequestMapping(value="/eliminarCategoria", method = RequestMethod.GET)
	public String eliminarCategoria(ModelMap model) {
            List <Categoria> listaCategorias = null;
            listaCategorias = daoCat.findAll();
            model.addAttribute("listaCategorias", listaCategorias);
            return "eliminarCategoria";
	}
        
        @RequestMapping(value="/borrarCategoriaConcreta", method = RequestMethod.GET)
	public String borrarCategoriaConcreta(@RequestParam (value = "id", required = false, defaultValue= "1")int idCat) {
            List <Producto> listaProductos = null;
            listaProductos = daoProd.findAll();
            for(Producto producto:listaProductos){
                if (producto.getCategoria().getIdcategoria() == idCat){
                    daoProd.delete(producto.getIdproducto());
                }
            }
            daoCat.delete(idCat);
            return "adminOpciones";
	}
}
