/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author arthu
 */
@Entity
@Table(name = "compra", catalog = "mercado", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdCom", query = "SELECT c FROM Compra c WHERE c.idCom = :idCom"),
    @NamedQuery(name = "Compra.findByCpfCom", query = "SELECT c FROM Compra c WHERE c.cpfCom = :cpfCom"),
    @NamedQuery(name = "Compra.findByCliCom", query = "SELECT c FROM Compra c WHERE c.cliCom = :cliCom"),
    @NamedQuery(name = "Compra.findByProdCom", query = "SELECT c FROM Compra c WHERE c.prodCom = :prodCom"),
    @NamedQuery(name = "Compra.findByPrecoInd", query = "SELECT c FROM Compra c WHERE c.precoInd = :precoInd"),
    @NamedQuery(name = "Compra.findByQtdeCom", query = "SELECT c FROM Compra c WHERE c.qtdeCom = :qtdeCom"),
    @NamedQuery(name = "Compra.findByDataCom", query = "SELECT c FROM Compra c WHERE c.dataCom = :dataCom"),
    @NamedQuery(name = "Compra.findByPrecoFin", query = "SELECT c FROM Compra c WHERE c.precoFin = :precoFin")})
public class Compra implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_com")
    private Integer idCom;
    @Basic(optional = false)
    @Column(name = "cpf_com")
    private long cpfCom;
    @Basic(optional = false)
    @Column(name = "cli_com")
    private String cliCom;
    @Basic(optional = false)
    @Column(name = "prod_com")
    private String prodCom;
    @Basic(optional = false)
    @Column(name = "preco_ind")
    private float precoInd;
    @Basic(optional = false)
    @Column(name = "qtde_com")
    private int qtdeCom;
    @Basic(optional = false)
    @Column(name = "data_com")
    @Temporal(TemporalType.DATE)
    private Date dataCom;
    @Basic(optional = false)
    @Column(name = "preco_fin")
    private float precoFin;

    public Compra() {
    }

    public Compra(Integer idCom) {
        this.idCom = idCom;
    }

    public Compra(Integer idCom, long cpfCom, String cliCom, String prodCom, float precoInd, int qtdeCom, Date dataCom, float precoFin) {
        this.idCom = idCom;
        this.cpfCom = cpfCom;
        this.cliCom = cliCom;
        this.prodCom = prodCom;
        this.precoInd = precoInd;
        this.qtdeCom = qtdeCom;
        this.dataCom = dataCom;
        this.precoFin = precoFin;
    }

    public Integer getIdCom() {
        return idCom;
    }

    public void setIdCom(Integer idCom) {
        Integer oldIdCom = this.idCom;
        this.idCom = idCom;
        changeSupport.firePropertyChange("idCom", oldIdCom, idCom);
    }

    public long getCpfCom() {
        return cpfCom;
    }

    public void setCpfCom(long cpfCom) {
        long oldCpfCom = this.cpfCom;
        this.cpfCom = cpfCom;
        changeSupport.firePropertyChange("cpfCom", oldCpfCom, cpfCom);
    }

    public String getCliCom() {
        return cliCom;
    }

    public void setCliCom(String cliCom) {
        String oldCliCom = this.cliCom;
        this.cliCom = cliCom;
        changeSupport.firePropertyChange("cliCom", oldCliCom, cliCom);
    }

    public String getProdCom() {
        return prodCom;
    }

    public void setProdCom(String prodCom) {
        String oldProdCom = this.prodCom;
        this.prodCom = prodCom;
        changeSupport.firePropertyChange("prodCom", oldProdCom, prodCom);
    }

    public float getPrecoInd() {
        return precoInd;
    }

    public void setPrecoInd(float precoInd) {
        float oldPrecoInd = this.precoInd;
        this.precoInd = precoInd;
        changeSupport.firePropertyChange("precoInd", oldPrecoInd, precoInd);
    }

    public int getQtdeCom() {
        return qtdeCom;
    }

    public void setQtdeCom(int qtdeCom) {
        int oldQtdeCom = this.qtdeCom;
        this.qtdeCom = qtdeCom;
        changeSupport.firePropertyChange("qtdeCom", oldQtdeCom, qtdeCom);
    }

    public Date getDataCom() {
        return dataCom;
    }

    public void setDataCom(Date dataCom) {
        Date oldDataCom = this.dataCom;
        this.dataCom = dataCom;
        changeSupport.firePropertyChange("dataCom", oldDataCom, dataCom);
    }

    public float getPrecoFin() {
        return precoFin;
    }

    public void setPrecoFin(float precoFin) {
        float oldPrecoFin = this.precoFin;
        this.precoFin = precoFin;
        changeSupport.firePropertyChange("precoFin", oldPrecoFin, precoFin);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCom != null ? idCom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCom == null && other.idCom != null) || (this.idCom != null && !this.idCom.equals(other.idCom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Compra[ idCom=" + idCom + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
