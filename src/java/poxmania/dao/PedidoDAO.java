//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import poxmania.model.Pedido;
import poxmania.model.Usuario;

@Component
public class PedidoDAO extends GeneralDAO <Pedido, Integer>{

    public PedidoDAO (){
        super();
    }
    
    public List<Pedido> findByUsuario (Usuario userId){
        this.open();
        TypedQuery<Pedido> query= getManager().createNamedQuery("Pedido.findByUsuario", Pedido.class);
        query.setParameter("idusuario", userId);
        List <Pedido> lista=query.getResultList();
        this.close();
        return lista;
    }
   
    
}
