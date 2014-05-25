//Autores: Samuel Martin y Juan Antonio Echeverrias

package poxmania.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import poxmania.dao.CategoriaDAO;
import poxmania.dao.ProductoDAO;
import poxmania.model.Categoria;
import poxmania.model.Producto;

@Controller
public class ProductoController {

    final String BARRA = "/";

    @Autowired
    private ServletContext servletContext;

    @Autowired
    CategoriaDAO daoCat;

    @Autowired
    ProductoDAO daoProd;

    @RequestMapping(value = "/buscarProducto", method = RequestMethod.GET)
    public String buscarProducto(@RequestParam(value = "nombre") String nombre, ModelMap model,HttpSession session) {
        List<Producto> listaProductos = null;
        listaProductos = daoProd.findByNombreproducto(nombre);
        List<Categoria> listaCategorias = null;
        listaCategorias = daoCat.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        session.setAttribute("listaproductos", listaProductos);
        return "index";
    }

    @RequestMapping(value = "/altaProducto", method = RequestMethod.GET)
    public String altaProducto(ModelMap model) {
        List<Categoria> listaCategorias = null;
        listaCategorias = daoCat.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "altaProducto";
    }

    @RequestMapping(value = "/editarProducto", method = RequestMethod.GET)
    public String editarProducto(ModelMap model) {
        List<Producto> listaProductos = null;
        listaProductos = daoProd.findAll();
        model.addAttribute("listaProductos", listaProductos);
        return "elegirProducto";
    }

    @RequestMapping(value = "/editarProductoConcreto", method = RequestMethod.GET)
    public String editarProductoConcreto(@RequestParam(value = "id", required = false, defaultValue = "1") int idProd, ModelMap model) {
        Producto prod = daoProd.get(idProd);
        List<Categoria> listaCategorias = null;
        listaCategorias = daoCat.findAll();
        model.addAttribute("producto", prod);
        model.addAttribute("listaCategorias", listaCategorias);
        return "editarProducto";
    }

    @RequestMapping(value = "/editarProductoFin", method = RequestMethod.POST)
    public String editarProductoFin(@RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "categoria") String categoria,
            @RequestParam(value = "idproducto") int id,
            @RequestParam(value = "descripcion") String descripcion,
            @RequestParam(value = "precio") double precio,
            @RequestParam(value = "imagen") MultipartFile imagen,
            @RequestParam(value = "rutaImg") String rutaImg,
            @RequestParam(value = "stock") int stock) {

        if (!imagen.isEmpty()) {
            try {
                validateImage(imagen);

            } catch (RuntimeException re) {
                //bindingResult.reject(re.getMessage());
                return "adminOpciones";
            }

            try {
                rutaImg = saveImage(imagen.getOriginalFilename() + ".jpg", imagen);
            } catch (IOException e) {
                //bindingResult.reject(e.getMessage());
                return "adminOpciones";
            }
        }
        Producto producto = daoProd.get(id);
        String[] idCat = categoria.split("\\s+");
        Categoria cat = daoCat.get(Integer.parseInt(idCat[0]));
        producto.setCategoria(cat);
        producto.setDescripcion(descripcion);
        producto.setImagen(rutaImg);
        producto.setNombreproducto(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
        daoProd.update(producto);
        return "redirect:editarProducto";
    }

    @RequestMapping(value = "/bajaProducto", method = RequestMethod.GET)
    public String bajaProducto(ModelMap model) {
        List<Producto> listaProductos = null;
        listaProductos = daoProd.findAll();
        model.addAttribute("listaProductos", listaProductos);
        return "bajaProducto";
    }

    @RequestMapping(value = "/borrarProductoConcreto", method = RequestMethod.GET)
    public String borrarProductoConcreto(@RequestParam(value = "id", required = false, defaultValue = "1") int idProd) {
        daoProd.delete(idProd);
        return "adminOpciones";
    }

    @RequestMapping(value = "/insertarProducto", method = RequestMethod.POST)
    public String insertarProducto(@RequestParam(value = "imagen", required = false) MultipartFile imagen, 
            @RequestParam(value = "nombre") String nombre, 
            @RequestParam(value = "categoria") String categoria, 
            @RequestParam(value = "descripcion") String descripcion, 
            @RequestParam(value = "precio") double precio, 
            @RequestParam(value = "stock") int stock) {

        String rutaImg = "";
        if (!imagen.isEmpty()) {
            try {
                validateImage(imagen);

            } catch (RuntimeException re) {
                //bindingResult.reject(re.getMessage());
                return "adminOpciones";
            }

            try {
                rutaImg = saveImage(imagen.getOriginalFilename() + ".jpg", imagen);
            } catch (IOException e) {
                //bindingResult.reject(e.getMessage());
                return "adminOpciones";
            }
        }
        String[] idCat = categoria.split("\\s+");
        Categoria cat = daoCat.get(Integer.parseInt(idCat[0]));
        Producto prod = new Producto(nombre, descripcion, precio, rutaImg, stock, cat);
        daoProd.save(prod);

        return "adminOpciones";
    }

    private void validateImage(MultipartFile imagen) {
        if (!imagen.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted");
        }
    }

    private String saveImage(String filename, MultipartFile imagen)
            throws RuntimeException, IOException {
        File file;
        try {
            file = new File(servletContext.getRealPath("/") + File.separator + ".."
                    + File.separator + ".." + File.separator + "web" + File.separator + "images"
                    + File.separator + filename);

            FileUtils.writeByteArrayToFile(file, imagen.getBytes());
            System.out.println("Go to the location:  " + file.toString()
                    + " on your computer and verify that the image has been stored.");
        } catch (IOException e) {
            throw e;
        }
        return BARRA + "images" + BARRA + filename;
    }
}
