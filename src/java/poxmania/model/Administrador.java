//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ADMINISTRADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findByNombreAndPass", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre AND a.pass = :pass"),
    @NamedQuery(name = "Administrador.findByIdadmin", query = "SELECT a FROM Administrador a WHERE a.idadmin = :idadmin"),
    @NamedQuery(name = "Administrador.findByNombre", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Administrador.findByPass", query = "SELECT a FROM Administrador a WHERE a.pass = :pass")})
public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDADMIN")
    private Integer idadmin;
    
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Size(max = 60)
    @Column(name = "PASS")
    private String pass;

    public Administrador() {
    }

    public Administrador(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public Integer getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadmin != null ? idadmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idadmin == null && other.idadmin != null) || (this.idadmin != null && !this.idadmin.equals(other.idadmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poxmania.model.Administrador[ idadmin=" + idadmin + " ]";
    }
    
}
