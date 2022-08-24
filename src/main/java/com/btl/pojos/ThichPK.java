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

/**
 *
 * @author Admin
 */
@Embeddable
public class ThichPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_baiviet")
    private int idBaiviet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;

    public ThichPK() {
    }

    public ThichPK(int idBaiviet, int idUser) {
        this.idBaiviet = idBaiviet;
        this.idUser = idUser;
    }

    public int getIdBaiviet() {
        return idBaiviet;
    }

    public void setIdBaiviet(int idBaiviet) {
        this.idBaiviet = idBaiviet;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idBaiviet;
        hash += (int) idUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThichPK)) {
            return false;
        }
        ThichPK other = (ThichPK) object;
        if (this.idBaiviet != other.idBaiviet) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.ThichPK[ idBaiviet=" + idBaiviet + ", idUser=" + idUser + " ]";
    }
    
}
