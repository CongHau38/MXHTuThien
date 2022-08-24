/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Embeddable
public class HastagPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_baiviet")
    private int idBaiviet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "hastag")
    private String hastag;

    public HastagPK() {
    }

    public HastagPK(int idBaiviet, String hastag) {
        this.idBaiviet = idBaiviet;
        this.hastag = hastag;
    }

    public int getIdBaiviet() {
        return idBaiviet;
    }

    public void setIdBaiviet(int idBaiviet) {
        this.idBaiviet = idBaiviet;
    }

    public String getHastag() {
        return hastag;
    }

    public void setHastag(String hastag) {
        this.hastag = hastag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idBaiviet;
        hash += (hastag != null ? hastag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HastagPK)) {
            return false;
        }
        HastagPK other = (HastagPK) object;
        if (this.idBaiviet != other.idBaiviet) {
            return false;
        }
        if ((this.hastag == null && other.hastag != null) || (this.hastag != null && !this.hastag.equals(other.hastag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.HastagPK[ idBaiviet=" + idBaiviet + ", hastag=" + hastag + " ]";
    }
    
}
