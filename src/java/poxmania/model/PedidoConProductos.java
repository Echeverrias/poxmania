//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.model;

import java.util.List;

public class PedidoConProductos {

    Pedido pedido;
    List <ProductoCarro> productos;
    
    public PedidoConProductos(Pedido pedido, List<ProductoCarro> productos) {
        this.pedido = pedido;
        this.productos = productos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<ProductoCarro> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoCarro> productos) {
        this.productos = productos;
    }
       
}
