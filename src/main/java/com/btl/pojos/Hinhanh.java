/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "hinhanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hinhanh.findAll", query = "SELECT h FROM Hinhanh h"),
    @NamedQuery(name = "Hinhanh.findByIdHinhanh", query = "SELECT h FROM Hinhanh h WHERE h.idHinhanh = :idHinhanh"),
    @NamedQuery(name = "Hinhanh.findByAnh", query = "SELECT h FROM Hinhanh h WHERE h.anh = :anh")})
public class Hinhanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hinhanh")
    private Integer idHinhanh;
    @Size(max = 255)
    @Column(name = "anh")
    private String anh;
    @JoinColumn(name = "id_baiviet", referencedColumnName = "id_baiviet")
    @ManyToOne
    private Baiviet idBaiviet;
    @JoinColumn(name = "id_vatpham", referencedColumnName = "id_vatpham")
    @ManyToOne
    private Vatpham idVatpham;

    public Hinhanh() {
    }

    public Hinhanh(Integer idHinhanh) {
        this.idHinhanh = idHinhanh;
    }

    public Integer getIdHinhanh() {
        return idHinhanh;
    }

    public void setIdHinhanh(Integer idHinhanh) {
        this.idHinhanh = idHinhanh;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Baiviet getIdBaiviet() {
        return idBaiviet;
    }

    public void setIdBaiviet(Baiviet idBaiviet) {
        this.idBaiviet = idBaiviet;
    }

    public Vatpham getIdVatpham() {
        return idVatpham;
    }

    public void setIdVatpham(Vatpham idVatpham) {
        this.idVatpham = idVatpham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHinhanh != null ? idHinhanh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hinhanh)) {
            return false;
        }
        Hinhanh other = (Hinhanh) object;
        if ((this.idHinhanh == null && other.idHinhanh != null) || (this.idHinhanh != null && !this.idHinhanh.equals(other.idHinhanh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Hinhanh[ idHinhanh=" + idHinhanh + " ]";
    }
    
}
