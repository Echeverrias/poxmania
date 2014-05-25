//Autores: Samuel Martin y Juan Antonio Echeverrias 

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


@Entity
@Table(name = "PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findByCategoria", query = "SELECT p FROM Producto p LEFT JOIN FETCH p.categoria WHERE p.categoria.nombrecategoria = :categoria"),
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto"),
    @NamedQuery(name = "Producto.findByNombreproducto", query = "SELECT p FROM Producto p WHERE p.nombreproducto LIKE CONCAT(:nombreproducto, '%')"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByImagen", query = "SELECT p FROM Producto p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRODUCTO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idproducto;
    
    @Size(max = 30)
    @Column(name = "NOMBREPRODUCTO")
    private String nombreproducto;
    
    @Size(max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private double precio;
    
    @Size(max = 200)
    @Column(name = "IMAGEN")
    private String imagen;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "STOCK")
    private int stock;
    
    @JoinColumn(name = "CATEGORIA", referencedColumnName = "IDCATEGORIA")
    @ManyToOne
    private Categoria categoria;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Relacionproductopedido> relacionproductopedidoList;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio, String imagen, int stock, Categoria cat) {
        this.nombreproducto = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen= imagen;
        this.stock = stock;
        this.categoria = cat;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public List<Relacionproductopedido> getRelacionproductopedidoList() {
        return relacionproductopedidoList;
    }

    public void setRelacionproductopedidoList(List<Relacionproductopedido> relacionproductopedidoList) {
        this.relacionproductopedidoList = relacionproductopedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "poxmania.model.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
