//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import poxmania.model.Administrador;

@Component
public class AdminDAO extends GeneralDAO<AdminDAO, Integer> {

    public AdminDAO() {
        super();
    }

    public List<Administrador> findByNombreAdmin(String nombre, String pass) {
        this.open();
        TypedQuery<Administrador> query = getManager().createNamedQuery("Administrador.findByNombreAndPass", Administrador.class);
        query.setParameter("nombre", nombre);
        query.setParameter("pass", pass);
        List<Administrador> lista = query.getResultList();
        this.close();
        return lista;
    }

}
