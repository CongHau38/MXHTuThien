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
public class DaugiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vatpham")
    private int idVatpham;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;

    public DaugiaPK() {
    }

    public DaugiaPK(int idVatpham, int idUser) {
        this.idVatpham = idVatpham;
        this.idUser = idUser;
    }

    public int getIdVatpham() {
        return idVatpham;
    }

    public void setIdVatpham(int idVatpham) {
        this.idVatpham = idVatpham;
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
        hash += (int) idVatpham;
        hash += (int) idUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaugiaPK)) {
            return false;
        }
        DaugiaPK other = (DaugiaPK) object;
        if (this.idVatpham != other.idVatpham) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.DaugiaPK[ idVatpham=" + idVatpham + ", idUser=" + idUser + " ]";
    }
    
}
