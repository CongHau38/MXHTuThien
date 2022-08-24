/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "hastag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hastag.findAll", query = "SELECT h FROM Hastag h"),
    @NamedQuery(name = "Hastag.findByIdBaiviet", query = "SELECT h FROM Hastag h WHERE h.hastagPK.idBaiviet = :idBaiviet"),
    @NamedQuery(name = "Hastag.findByHastag", query = "SELECT h FROM Hastag h WHERE h.hastagPK.hastag = :hastag")})
public class Hastag implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HastagPK hastagPK;
    @JoinColumn(name = "id_baiviet", referencedColumnName = "id_baiviet", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Baiviet baiviet;

    public Hastag() {
    }

    public Hastag(HastagPK hastagPK) {
        this.hastagPK = hastagPK;
    }

    public Hastag(int idBaiviet, String hastag) {
        this.hastagPK = new HastagPK(idBaiviet, hastag);
    }

    public HastagPK getHastagPK() {
        return hastagPK;
    }

    public void setHastagPK(HastagPK hastagPK) {
        this.hastagPK = hastagPK;
    }

    public Baiviet getBaiviet() {
        return baiviet;
    }

    public void setBaiviet(Baiviet baiviet) {
        this.baiviet = baiviet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hastagPK != null ? hastagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hastag)) {
            return false;
        }
        Hastag other = (Hastag) object;
        if ((this.hastagPK == null && other.hastagPK != null) || (this.hastagPK != null && !this.hastagPK.equals(other.hastagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Hastag[ hastagPK=" + hastagPK + " ]";
    }
    
}
