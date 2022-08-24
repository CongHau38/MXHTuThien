/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

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

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "daugia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Daugia.findAll", query = "SELECT d FROM Daugia d"),
    @NamedQuery(name = "Daugia.findByIdVatpham", query = "SELECT d FROM Daugia d WHERE d.daugiaPK.idVatpham = :idVatpham"),
    @NamedQuery(name = "Daugia.findByIdUser", query = "SELECT d FROM Daugia d WHERE d.daugiaPK.idUser = :idUser"),
    @NamedQuery(name = "Daugia.findByGia", query = "SELECT d FROM Daugia d WHERE d.gia = :gia")})
public class Daugia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DaugiaPK daugiaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia")
    private long gia;
    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "id_vatpham", referencedColumnName = "id_vatpham", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vatpham vatpham;

    public Daugia() {
    }

    public Daugia(DaugiaPK daugiaPK) {
        this.daugiaPK = daugiaPK;
    }

    public Daugia(DaugiaPK daugiaPK, long gia) {
        this.daugiaPK = daugiaPK;
        this.gia = gia;
    }

    public Daugia(int idVatpham, int idUser) {
        this.daugiaPK = new DaugiaPK(idVatpham, idUser);
    }

    public DaugiaPK getDaugiaPK() {
        return daugiaPK;
    }

    public void setDaugiaPK(DaugiaPK daugiaPK) {
        this.daugiaPK = daugiaPK;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vatpham getVatpham() {
        return vatpham;
    }

    public void setVatpham(Vatpham vatpham) {
        this.vatpham = vatpham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (daugiaPK != null ? daugiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Daugia)) {
            return false;
        }
        Daugia other = (Daugia) object;
        if ((this.daugiaPK == null && other.daugiaPK != null) || (this.daugiaPK != null && !this.daugiaPK.equals(other.daugiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Daugia[ daugiaPK=" + daugiaPK + " ]";
    }
    
}
