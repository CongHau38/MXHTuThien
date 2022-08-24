/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.userPK.id = :id"),
    @NamedQuery(name = "User.findByHo", query = "SELECT u FROM User u WHERE u.ho = :ho"),
    @NamedQuery(name = "User.findByTen", query = "SELECT u FROM User u WHERE u.ten = :ten"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findBySodienthoai", query = "SELECT u FROM User u WHERE u.userPK.sodienthoai = :sodienthoai"),
    @NamedQuery(name = "User.findByTaikhoan", query = "SELECT u FROM User u WHERE u.taikhoan = :taikhoan"),
    @NamedQuery(name = "User.findByMatkhau", query = "SELECT u FROM User u WHERE u.matkhau = :matkhau"),
    @NamedQuery(name = "User.findByPhanquyen", query = "SELECT u FROM User u WHERE u.phanquyen = :phanquyen"),
    @NamedQuery(name = "User.findByAnh", query = "SELECT u FROM User u WHERE u.anh = :anh")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPK userPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ho")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ten")
    private String ten;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "taikhoan")
    private String taikhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "matkhau")
    private String matkhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phanquyen")
    private String phanquyen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "anh")
    private String anh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Set<Phanhoi> phanhoiSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Set<Vatpham> vatphamSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Set<Binhluan> binhluanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Daugia> daugiaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUserReport")
    private Set<Report> reportSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Thich> thichSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Set<Baiviet> baivietSet;

    public User() {
    }

    public User(UserPK userPK) {
        this.userPK = userPK;
    }

    public User(UserPK userPK, String ho, String ten, String email, String taikhoan, String matkhau, String phanquyen, String anh) {
        this.userPK = userPK;
        this.ho = ho;
        this.ten = ten;
        this.email = email;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.phanquyen = phanquyen;
        this.anh = anh;
    }

    public User(int id, String sodienthoai) {
        this.userPK = new UserPK(id, sodienthoai);
    }

    public UserPK getUserPK() {
        return userPK;
    }

    public void setUserPK(UserPK userPK) {
        this.userPK = userPK;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(String phanquyen) {
        this.phanquyen = phanquyen;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @XmlTransient
    public Set<Phanhoi> getPhanhoiSet() {
        return phanhoiSet;
    }

    public void setPhanhoiSet(Set<Phanhoi> phanhoiSet) {
        this.phanhoiSet = phanhoiSet;
    }

    @XmlTransient
    public Set<Vatpham> getVatphamSet() {
        return vatphamSet;
    }

    public void setVatphamSet(Set<Vatpham> vatphamSet) {
        this.vatphamSet = vatphamSet;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return binhluanSet;
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
    }

    @XmlTransient
    public Set<Daugia> getDaugiaSet() {
        return daugiaSet;
    }

    public void setDaugiaSet(Set<Daugia> daugiaSet) {
        this.daugiaSet = daugiaSet;
    }

    @XmlTransient
    public Set<Report> getReportSet() {
        return reportSet;
    }

    public void setReportSet(Set<Report> reportSet) {
        this.reportSet = reportSet;
    }

    @XmlTransient
    public Set<Thich> getThichSet() {
        return thichSet;
    }

    public void setThichSet(Set<Thich> thichSet) {
        this.thichSet = thichSet;
    }

    @XmlTransient
    public Set<Baiviet> getBaivietSet() {
        return baivietSet;
    }

    public void setBaivietSet(Set<Baiviet> baivietSet) {
        this.baivietSet = baivietSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userPK != null ? userPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userPK == null && other.userPK != null) || (this.userPK != null && !this.userPK.equals(other.userPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.User[ userPK=" + userPK + " ]";
    }
    
}
