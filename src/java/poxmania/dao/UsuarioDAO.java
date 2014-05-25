//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import poxmania.model.Usuario;

@Component
public class UsuarioDAO extends GeneralDAO <Usuario, Integer>{
    
    public UsuarioDAO (){
        super();
    }
    
    public Usuario findByNick (String nick){
        this.open();
        TypedQuery <Usuario> query= getManager().createNamedQuery("Usuario.findByNick", Usuario.class);
        query.setParameter("nick", nick);
        List <Usuario> usuarios =  query.getResultList();
        this.close();
        Usuario usuario=null;
        if(!usuarios.isEmpty()){
            usuario = usuarios.get(0);
        }
        return usuario;
    }
    
}
