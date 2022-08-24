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
@Table(name = "vatpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vatpham.findAll", query = "SELECT v FROM Vatpham v"),
    @NamedQuery(name = "Vatpham.findByIdVatpham", query = "SELECT v FROM Vatpham v WHERE v.idVatpham = :idVatpham"),
    @NamedQuery(name = "Vatpham.findByThoigian", query = "SELECT v FROM Vatpham v WHERE v.thoigian = :thoigian"),
    @NamedQuery(name = "Vatpham.findByThoigianKetthuc", query = "SELECT v FROM Vatpham v WHERE v.thoigianKetthuc = :thoigianKetthuc"),
    @NamedQuery(name = "Vatpham.findByGiakhoidiem", query = "SELECT v FROM Vatpham v WHERE v.giakhoidiem = :giakhoidiem"),
    @NamedQuery(name = "Vatpham.findByNoidung", query = "SELECT v FROM Vatpham v WHERE v.noidung = :noidung"),
    @NamedQuery(name = "Vatpham.findByIdUserThanhcong", query = "SELECT v FROM Vatpham v WHERE v.idUserThanhcong = :idUserThanhcong")})
public class Vatpham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vatpham")
    private Integer idVatpham;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigian;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigian_ketthuc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigianKetthuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giakhoidiem")
    private long giakhoidiem;
    @Size(max = 45)
    @Column(name = "noidung")
    private String noidung;
    @Column(name = "id_user_thanhcong")
    private Integer idUserThanhcong;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;
    @OneToMany(mappedBy = "idVatpham")
    private Set<Hinhanh> hinhanhSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vatpham")
    private Set<Daugia> daugiaSet;

    public Vatpham() {
    }

    public Vatpham(Integer idVatpham) {
        this.idVatpham = idVatpham;
    }

    public Vatpham(Integer idVatpham, Date thoigian, Date thoigianKetthuc, long giakhoidiem) {
        this.idVatpham = idVatpham;
        this.thoigian = thoigian;
        this.thoigianKetthuc = thoigianKetthuc;
        this.giakhoidiem = giakhoidiem;
    }

    public Integer getIdVatpham() {
        return idVatpham;
    }

    public void setIdVatpham(Integer idVatpham) {
        this.idVatpham = idVatpham;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public Date getThoigianKetthuc() {
        return thoigianKetthuc;
    }

    public void setThoigianKetthuc(Date thoigianKetthuc) {
        this.thoigianKetthuc = thoigianKetthuc;
    }

    public long getGiakhoidiem() {
        return giakhoidiem;
    }

    public void setGiakhoidiem(long giakhoidiem) {
        this.giakhoidiem = giakhoidiem;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Integer getIdUserThanhcong() {
        return idUserThanhcong;
    }

    public void setIdUserThanhcong(Integer idUserThanhcong) {
        this.idUserThanhcong = idUserThanhcong;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public Set<Hinhanh> getHinhanhSet() {
        return hinhanhSet;
    }

    public void setHinhanhSet(Set<Hinhanh> hinhanhSet) {
        this.hinhanhSet = hinhanhSet;
    }

    @XmlTransient
    public Set<Daugia> getDaugiaSet() {
        return daugiaSet;
    }

    public void setDaugiaSet(Set<Daugia> daugiaSet) {
        this.daugiaSet = daugiaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVatpham != null ? idVatpham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vatpham)) {
            return false;
        }
        Vatpham other = (Vatpham) object;
        if ((this.idVatpham == null && other.idVatpham != null) || (this.idVatpham != null && !this.idVatpham.equals(other.idVatpham))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Vatpham[ idVatpham=" + idVatpham + " ]";
    }
    
}
