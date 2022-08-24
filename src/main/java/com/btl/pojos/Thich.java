/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "thich")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thich.findAll", query = "SELECT t FROM Thich t"),
    @NamedQuery(name = "Thich.findByIdBaiviet", query = "SELECT t FROM Thich t WHERE t.thichPK.idBaiviet = :idBaiviet"),
    @NamedQuery(name = "Thich.findByIdUser", query = "SELECT t FROM Thich t WHERE t.thichPK.idUser = :idUser"),
    @NamedQuery(name = "Thich.findByIcon", query = "SELECT t FROM Thich t WHERE t.icon = :icon")})
public class Thich implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ThichPK thichPK;
    @Size(max = 45)
    @Column(name = "icon")
    private String icon;
    @JoinColumn(name = "id_baiviet", referencedColumnName = "id_baiviet", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Baiviet baiviet;
    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Thich() {
    }

    public Thich(ThichPK thichPK) {
        this.thichPK = thichPK;
    }

    public Thich(int idBaiviet, int idUser) {
        this.thichPK = new ThichPK(idBaiviet, idUser);
    }

    public ThichPK getThichPK() {
        return thichPK;
    }

    public void setThichPK(ThichPK thichPK) {
        this.thichPK = thichPK;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Baiviet getBaiviet() {
        return baiviet;
    }

    public void setBaiviet(Baiviet baiviet) {
        this.baiviet = baiviet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (thichPK != null ? thichPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thich)) {
            return false;
        }
        Thich other = (Thich) object;
        if ((this.thichPK == null && other.thichPK != null) || (this.thichPK != null && !this.thichPK.equals(other.thichPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Thich[ thichPK=" + thichPK + " ]";
    }
    
}
