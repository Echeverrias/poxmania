//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RelacionproductopedidoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPEDIDO")
    private int idpedido;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRODUCTO")
    private int idproducto;

    public RelacionproductopedidoPK() {
    }

    public RelacionproductopedidoPK(int idpedido, int idproducto) {
        this.idpedido = idpedido;
        this.idproducto = idproducto;
    }
    
    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpedido;
        hash += (int) idproducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionproductopedidoPK)) {
            return false;
        }
        RelacionproductopedidoPK other = (RelacionproductopedidoPK) object;
        if (this.idpedido != other.idpedido) {
            return false;
        }
        if (this.idproducto != other.idproducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poxmania.model.RelacionproductopedidoPK[ idpedido=" + idpedido + ", idproducto=" + idproducto + " ]";
    }
    
}
