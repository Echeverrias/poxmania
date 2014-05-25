//Autores: Samuel Martin y Juan Antonio Echeverrias 

package poxmania.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "RELACIONPRODUCTOPEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relacionproductopedido.findAll", query = "SELECT r FROM Relacionproductopedido r"),
    @NamedQuery(name = "Relacionproductopedido.findByIdpedido", query = "SELECT r FROM Relacionproductopedido r WHERE r.relacionproductopedidoPK.idpedido = :idpedido"),
    @NamedQuery(name = "Relacionproductopedido.findByIdproducto", query = "SELECT r FROM Relacionproductopedido r WHERE r.relacionproductopedidoPK.idproducto = :idproducto"),
    @NamedQuery(name = "Relacionproductopedido.findByCantidad", query = "SELECT r FROM Relacionproductopedido r WHERE r.cantidad = :cantidad")})
public class Relacionproductopedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelacionproductopedidoPK relacionproductopedidoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    
    @JoinColumn(name = "IDPEDIDO", referencedColumnName = "IDPEDIDO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;
    
    @JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Relacionproductopedido() {
    }

    public Relacionproductopedido(RelacionproductopedidoPK relacionproductopedidoPK) {
        this.relacionproductopedidoPK = relacionproductopedidoPK;
    }

    public Relacionproductopedido(RelacionproductopedidoPK relacionproductopedidoPK, int cantidad) {
        this.relacionproductopedidoPK = relacionproductopedidoPK;
        this.cantidad = cantidad;
    }

    public Relacionproductopedido(int idpedido, int idproducto) {
        this.relacionproductopedidoPK = new RelacionproductopedidoPK(idpedido, idproducto);
    }
    
    public Relacionproductopedido(int idpedido, int idproducto, int cantidad) {
        this.relacionproductopedidoPK = new RelacionproductopedidoPK(idpedido, idproducto);
        this.cantidad = cantidad;
    }

    public RelacionproductopedidoPK getRelacionproductopedidoPK() {
        return relacionproductopedidoPK;
    }

    public void setRelacionproductopedidoPK(RelacionproductopedidoPK relacionproductopedidoPK) {
        this.relacionproductopedidoPK = relacionproductopedidoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relacionproductopedidoPK != null ? relacionproductopedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relacionproductopedido)) {
            return false;
        }
        Relacionproductopedido other = (Relacionproductopedido) object;
        if ((this.relacionproductopedidoPK == null && other.relacionproductopedidoPK != null) || (this.relacionproductopedidoPK != null && !this.relacionproductopedidoPK.equals(other.relacionproductopedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poxmania.model.Relacionproductopedido[ relacionproductopedidoPK=" + relacionproductopedidoPK + " ]";
    }
    
}
