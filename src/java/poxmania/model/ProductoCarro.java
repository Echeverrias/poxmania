//Autores: Samuel Martin y Juan Antonio Echeverrias 
package poxmania.model;

import org.springframework.stereotype.Component;

@Component
public class ProductoCarro {

    private Producto prod;
    private int cantidad;

    public ProductoCarro() {
        this.prod = null;
        this.cantidad = 0;
    }

    public ProductoCarro(Producto prod, int cantidad) {
        this.prod = prod;
        this.cantidad = cantidad;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        }
    }

    public boolean incrementar(int unidades) {
        //incrementa las unidades    
        boolean exito = false;

        if (unidades > 0) {
            this.cantidad += unidades;
            exito = true;

        }
        return exito;
    }

    public boolean decrementar(int unidades) {
        //incrementa las unidades    
        boolean exito = false;

        if ((unidades > 0) && (unidades <= this.cantidad)) {
            this.cantidad -= unidades;
            exito = true;

        }
        return exito;
    }

    public String getIdString() {
        return Integer.toString(prod.getIdproducto());
    }

    public int getId() {
        return prod.getIdproducto();
    }

    public String toString() {
        String productoCarro = "";
        productoCarro += (prod.toString() + ", Unidades: " + cantidad);
        return productoCarro;
    }

}
