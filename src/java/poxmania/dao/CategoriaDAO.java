//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.dao;

import org.springframework.stereotype.Component;
import poxmania.model.Categoria;

@Component
public class CategoriaDAO extends GeneralDAO<Categoria,Integer> {

    public CategoriaDAO(){
        super();
    }

}//fin clase
