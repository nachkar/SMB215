/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smb215.smb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Peter
 */
@Entity
@Table(name = "product_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductStatus.findAll", query = "SELECT p FROM ProductStatus p"),
    @NamedQuery(name = "ProductStatus.findByPSid", query = "SELECT p FROM ProductStatus p WHERE p.pSid = :pSid"),
    @NamedQuery(name = "ProductStatus.findByDescription", query = "SELECT p FROM ProductStatus p WHERE p.description = :description")})
public class ProductStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PS_id")
    private Integer pSid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productStatus")
    private Collection<Products> productsCollection;

    public ProductStatus() {
    }

    public ProductStatus(Integer pSid) {
        this.pSid = pSid;
    }

    public ProductStatus(Integer pSid, String description) {
        this.pSid = pSid;
        this.description = description;
    }

    public Integer getPSid() {
        return pSid;
    }

    public void setPSid(Integer pSid) {
        this.pSid = pSid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pSid != null ? pSid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductStatus)) {
            return false;
        }
        ProductStatus other = (ProductStatus) object;
        if ((this.pSid == null && other.pSid != null) || (this.pSid != null && !this.pSid.equals(other.pSid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smb215.smb.ProductStatus[ pSid=" + pSid + " ]";
    }
    
}
