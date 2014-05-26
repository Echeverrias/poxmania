//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.dao;

import java.util.List;
import javax.persistence.*;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.springframework.stereotype.Component;
import poxmania.model.Relacionproductopedido;

@Component
public class RelacionproductopedidoDAO extends GeneralDAO<Relacionproductopedido,Integer> {

    public RelacionproductopedidoDAO(){
        super();
    }
   
    public List<Relacionproductopedido> findByIdPedido (int id){
        this.open();
        TypedQuery<Relacionproductopedido> query= getManager().createNamedQuery("Relacionproductopedido.findByIdpedido", Relacionproductopedido.class).setHint(QueryHints.REFRESH, HintValues.TRUE);
        query.setParameter("idpedido", id);
        List <Relacionproductopedido> lista=query.getResultList();
        this.close();
        return lista;
    }
    
    
}//fin clase