/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poxmania.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @autores Samuel Martin y Juan antonio Echeverrias Aranda 
 */
@Entity
@Table(name = "PEDIDOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findByUsuario", query = "SELECT p FROM Pedido p WHERE p.idusuario = :idusuario"),
    @NamedQuery(name = "Pedido.findByIdpedido", query = "SELECT p FROM Pedido p WHERE p.idpedido = :idpedido"),
    @NamedQuery(name = "Pedido.findByTotal", query = "SELECT p FROM Pedido p WHERE p.total = :total"),
    @NamedQuery(name = "Pedido.findByEstado", query = "SELECT p FROM Pedido p WHERE p.estado = :estado")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPEDIDO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idpedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private int total;
    @Size(max = 200)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<Relacionproductopedido> relacionproductopedidoList;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Pedido() {
    }

    
    public Pedido(Usuario u, int total, String estado) {
        this.idusuario = u;
        this.total = total;
        this.estado = estado;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Relacionproductopedido> getRelacionproductopedidoList() {
        return relacionproductopedidoList;
    }

    public void setRelacionproductopedidoList(List<Relacionproductopedido> relacionproductopedidoList) {
        this.relacionproductopedidoList = relacionproductopedidoList;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poxmania.model.Pedido[ idpedido=" + idpedido + " ]";
    }
    
}
