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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "baiviet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Baiviet.findAll", query = "SELECT b FROM Baiviet b"),
    @NamedQuery(name = "Baiviet.findByIdBaiviet", query = "SELECT b FROM Baiviet b WHERE b.idBaiviet = :idBaiviet"),
    @NamedQuery(name = "Baiviet.findByNoidung", query = "SELECT b FROM Baiviet b WHERE b.noidung = :noidung"),
    @NamedQuery(name = "Baiviet.findByThoigian", query = "SELECT b FROM Baiviet b WHERE b.thoigian = :thoigian")})
public class Baiviet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_baiviet")
    private Integer idBaiviet;
    @Size(max = 255)
    @Column(name = "noidung")
    private String noidung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigian;
    @OneToMany(mappedBy = "idBaiviet")
    private Set<Hinhanh> hinhanhSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baiviet")
    private Set<Hastag> hastagSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBaiviet")
    private Set<Binhluan> binhluanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baiviet")
    private Set<Thich> thichSet;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;

    public Baiviet() {
    }

    public Baiviet(Integer idBaiviet) {
        this.idBaiviet = idBaiviet;
    }

    public Baiviet(Integer idBaiviet, Date thoigian) {
        this.idBaiviet = idBaiviet;
        this.thoigian = thoigian;
    }

    public Integer getIdBaiviet() {
        return idBaiviet;
    }

    public void setIdBaiviet(Integer idBaiviet) {
        this.idBaiviet = idBaiviet;
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
    public Set<Hinhanh> getHinhanhSet() {
        return hinhanhSet;
    }

    public void setHinhanhSet(Set<Hinhanh> hinhanhSet) {
        this.hinhanhSet = hinhanhSet;
    }

    @XmlTransient
    public Set<Hastag> getHastagSet() {
        return hastagSet;
    }

    public void setHastagSet(Set<Hastag> hastagSet) {
        this.hastagSet = hastagSet;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return binhluanSet;
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
    }

    @XmlTransient
    public Set<Thich> getThichSet() {
        return thichSet;
    }

    public void setThichSet(Set<Thich> thichSet) {
        this.thichSet = thichSet;
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
        hash += (idBaiviet != null ? idBaiviet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baiviet)) {
            return false;
        }
        Baiviet other = (Baiviet) object;
        if ((this.idBaiviet == null && other.idBaiviet != null) || (this.idBaiviet != null && !this.idBaiviet.equals(other.idBaiviet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Baiviet[ idBaiviet=" + idBaiviet + " ]";
    }
    
}
