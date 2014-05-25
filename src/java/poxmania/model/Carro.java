//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Carro implements Serializable{
    
    List<ProductoCarro> contenido = null;
    int total;
    int precio;
    
    public Carro(){
        contenido = new ArrayList<ProductoCarro>();
        total=0;
        precio=0;
    }
    
    public Carro(List<ProductoCarro> contenido){
        this.contenido = contenido;
        total=this.total();
        precio=this.precio();
    }
    
    public int total(){
    //devuelve las unidades totales de los productos del carro    
        int cant=0;
        for (ProductoCarro prod: this.contenido){
            cant+=prod.getCantidad();
        }
      return cant;
    }
    
      public int precio(){
      //devuelve el precio total de las unidades de los productos del carro
        int valor=0;
        for (ProductoCarro prod: this.contenido){
            valor+=prod.getProd().getPrecio();
        }
      return valor;
    }
    
    public void meterEnCarro (ProductoCarro producto){
    //mete un producto en el carro    
        if (estaEnCarroId(producto.getId())<0){
            contenido.add(producto);
        }
        else {
            contenido.get(estaEnCarroId(producto.getId())).incrementar(producto.getCantidad());
        }
        total+=producto.getCantidad();
        precio+=(producto.getProd().getPrecio()*producto.getCantidad());
        
    }
    
    public int incrementarUnidades (int id, int cantidad){
    //incrementa las unidadedes de un producto del carro    
        int salida=0;
        if (cantidad < 1){//se ha metido un número erroneo de unidades a incrementar
            salida=-1;
        }
        else{
            int posicion=estaEnCarroId(id);
            if (posicion>=0){//el producto se encuentra en el carro y se procede a incrementar sus unidades
                if(contenido.get(posicion).incrementar(cantidad)){
                    total+=cantidad;
                    precio+=( contenido.get(posicion).getProd().getPrecio()*cantidad);
                    salida=1;
                }
                else{//el producto no está en el carro
                    salida=0;
                }
            }    
        }
        return salida;
    }

    
     public int decrementarUnidades (int id, int cantidad){
    //incrementa las unidadedes de un producto del carro    
        int salida=0;
        if (cantidad < 1){//se ha metido un número erroneo de unidades a incrementar
            salida=-1;
        }
        else{
            int posicion=estaEnCarroId(id);
            if (posicion>=0){//el producto se encuentra en el carro y se procede a incrementar sus unidades
                if(contenido.get(posicion).decrementar(cantidad)){
                    total-=cantidad;
                    precio-=( contenido.get(posicion).getProd().getPrecio()*cantidad);
                    salida=1;
                    if (contenido.get(posicion).getCantidad()==0){
                        sacarDeCarro(id);
                    }
                }
                else{//el producto no está en el carro
                    salida=0;
                }
            }    
        }
        
        return salida;
    }
     
    public boolean sacarDeCarro (int id) {
    //saca un producto del carro (todas las unidades de dicho producto)    
        boolean exito=false;
        int posicion = estaEnCarroId(id);
        if (posicion>=0){
             total-=contenido.get(posicion).getCantidad();
             precio-=contenido.get(posicion).getProd().getPrecio()*contenido.get(posicion).getCantidad();
             contenido.remove(posicion);
             exito=true;
        }
       return exito;
    }
    
    public void vaciarCarro (){
    //vacia completamente el carro    
        contenido=new ArrayList<ProductoCarro>();
        total=0;
        precio=0;
    }
        
    public boolean modificarCarro (int id, int cantidad){
    //modifica las unidades de un producto concreto del carro    
        boolean exito=false;//si se introduce una cantidad erronea se devolverá false
        int posicion=estaEnCarroId(id);
        int diferencia;
        if ((posicion>=0)){//el producto se encuentra en el carro
            if (cantidad >0){//se actualizan las unidades del producto
             diferencia=cantidad-contenido.get(posicion).getCantidad();
             contenido.get(posicion).setCantidad(cantidad);
             precio+=contenido.get(posicion).getProd().getPrecio()*diferencia;
             total+=diferencia;
             exito=true;
            }
            else if (cantidad==0){//se saca el producto del carro
                exito=sacarDeCarro(id);
            }
        }
        return exito;
    }
            
        
    
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<ProductoCarro> getContenido() {
        return contenido;
    }

    public void setContenido(List<ProductoCarro> contenido) {
        this.contenido = contenido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total();
    }
    
    
     public int estaEnCarroId (int id){
     //devuelve el índice, de la variable contenido, donde se encuentra el producto que coincide con el identificador que se le pasa
        int indice =-1;//devuelve -1 si el producto a buscar no se encuentra en el carro
        int contador=0;
        Iterator  <ProductoCarro> itr =  contenido.iterator();
        while ((itr.hasNext())&& (indice<0)){
            ProductoCarro prod = itr.next();
            if((prod.getId()==id)){
                indice=contador;
            }
            else{
                contador++;
            }
        }
        return indice;
    }
    
}
