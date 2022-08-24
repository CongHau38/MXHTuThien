/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "phanhoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phanhoi.findAll", query = "SELECT p FROM Phanhoi p"),
    @NamedQuery(name = "Phanhoi.findByIdPhanhoi", query = "SELECT p FROM Phanhoi p WHERE p.idPhanhoi = :idPhanhoi"),
    @NamedQuery(name = "Phanhoi.findByNoidung", query = "SELECT p FROM Phanhoi p WHERE p.noidung = :noidung"),
    @NamedQuery(name = "Phanhoi.findByThoigian", query = "SELECT p FROM Phanhoi p WHERE p.thoigian = :thoigian")})
public class Phanhoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_phanhoi")
    private Integer idPhanhoi;
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
    @JoinColumn(name = "id_binhluan", referencedColumnName = "id_binhluan")
    @ManyToOne(optional = false)
    private Binhluan idBinhluan;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;

    public Phanhoi() {
    }

    public Phanhoi(Integer idPhanhoi) {
        this.idPhanhoi = idPhanhoi;
    }

    public Phanhoi(Integer idPhanhoi, String noidung, Date thoigian) {
        this.idPhanhoi = idPhanhoi;
        this.noidung = noidung;
        this.thoigian = thoigian;
    }

    public Integer getIdPhanhoi() {
        return idPhanhoi;
    }

    public void setIdPhanhoi(Integer idPhanhoi) {
        this.idPhanhoi = idPhanhoi;
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

    public Binhluan getIdBinhluan() {
        return idBinhluan;
    }

    public void setIdBinhluan(Binhluan idBinhluan) {
        this.idBinhluan = idBinhluan;
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
        hash += (idPhanhoi != null ? idPhanhoi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phanhoi)) {
            return false;
        }
        Phanhoi other = (Phanhoi) object;
        if ((this.idPhanhoi == null && other.idPhanhoi != null) || (this.idPhanhoi != null && !this.idPhanhoi.equals(other.idPhanhoi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Phanhoi[ idPhanhoi=" + idPhanhoi + " ]";
    }
    
}
