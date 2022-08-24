/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "binhluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b"),
    @NamedQuery(name = "Binhluan.findByIdBinhluan", query = "SELECT b FROM Binhluan b WHERE b.idBinhluan = :idBinhluan"),
    @NamedQuery(name = "Binhluan.findByNoidung", query = "SELECT b FROM Binhluan b WHERE b.noidung = :noidung"),
    @NamedQuery(name = "Binhluan.findByThoigian", query = "SELECT b FROM Binhluan b WHERE b.thoigian = :thoigian")})
public class Binhluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_binhluan")
    private Integer idBinhluan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "noidung")
    private String noidung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigian;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBinhluan")
    private Set<Phanhoi> phanhoiSet;
    @JoinColumn(name = "id_baiviet", referencedColumnName = "id_baiviet")
    @ManyToOne(optional = false)
    private Baiviet idBaiviet;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;

    public Binhluan() {
    }

    public Binhluan(Integer idBinhluan) {
        this.idBinhluan = idBinhluan;
    }

    public Binhluan(Integer idBinhluan, String noidung, Date thoigian) {
        this.idBinhluan = idBinhluan;
        this.noidung = noidung;
        this.thoigian = thoigian;
    }

    public Integer getIdBinhluan() {
        return idBinhluan;
    }

    public void setIdBinhluan(Integer idBinhluan) {
        this.idBinhluan = idBinhluan;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    @XmlTransient
    public Set<Phanhoi> getPhanhoiSet() {
        return phanhoiSet;
    }

    public void setPhanhoiSet(Set<Phanhoi> phanhoiSet) {
        this.phanhoiSet = phanhoiSet;
    }

    public Baiviet getIdBaiviet() {
        return idBaiviet;
    }

    public void setIdBaiviet(Baiviet idBaiviet) {
        this.idBaiviet = idBaiviet;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBinhluan != null ? idBinhluan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Binhluan)) {
            return false;
        }
        Binhluan other = (Binhluan) object;
        if ((this.idBinhluan == null && other.idBinhluan != null) || (this.idBinhluan != null && !this.idBinhluan.equals(other.idBinhluan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Binhluan[ idBinhluan=" + idBinhluan + " ]";
    }
    
}
