/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author arthu
 */
@Entity
@Table(name = "produto", catalog = "mercado", schema = "")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProd", query = "SELECT p FROM Produto p WHERE p.idProd = :idProd"),
    @NamedQuery(name = "Produto.findByNomeProd", query = "SELECT p FROM Produto p WHERE p.nomeProd = :nomeProd"),
    @NamedQuery(name = "Produto.findByQtdeProd", query = "SELECT p FROM Produto p WHERE p.qtdeProd = :qtdeProd"),
    @NamedQuery(name = "Produto.findByPrecoProd", query = "SELECT p FROM Produto p WHERE p.precoProd = :precoProd")})
public class Produto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prod")
    private Integer idProd;
    @Basic(optional = false)
    @Column(name = "nome_prod")
    private String nomeProd;
    @Basic(optional = false)
    @Column(name = "qtde_prod")
    private int qtdeProd;
    @Basic(optional = false)
    @Column(name = "preco_prod")
    private float precoProd;

    public Produto() {
    }

    public Produto(Integer idProd) {
        this.idProd = idProd;
    }

    public Produto(Integer idProd, String nomeProd, int qtdeProd, float precoProd) {
        this.idProd = idProd;
        this.nomeProd = nomeProd;
        this.qtdeProd = qtdeProd;
        this.precoProd = precoProd;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        Integer oldIdProd = this.idProd;
        this.idProd = idProd;
        changeSupport.firePropertyChange("idProd", oldIdProd, idProd);
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        String oldNomeProd = this.nomeProd;
        this.nomeProd = nomeProd;
        changeSupport.firePropertyChange("nomeProd", oldNomeProd, nomeProd);
    }

    public int getQtdeProd() {
        return qtdeProd;
    }

    public void setQtdeProd(int qtdeProd) {
        int oldQtdeProd = this.qtdeProd;
        this.qtdeProd = qtdeProd;
        changeSupport.firePropertyChange("qtdeProd", oldQtdeProd, qtdeProd);
    }

    public float getPrecoProd() {
        return precoProd;
    }

    public void setPrecoProd(float precoProd) {
        float oldPrecoProd = this.precoProd;
        this.precoProd = precoProd;
        changeSupport.firePropertyChange("precoProd", oldPrecoProd, precoProd);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProd != null ? idProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProd == null && other.idProd != null) || (this.idProd != null && !this.idProd.equals(other.idProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Produto[ idProd=" + idProd + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
