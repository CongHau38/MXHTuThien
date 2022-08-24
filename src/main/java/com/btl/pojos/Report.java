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
@Table(name = "report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByIdreport", query = "SELECT r FROM Report r WHERE r.idreport = :idreport"),
    @NamedQuery(name = "Report.findByIdUser", query = "SELECT r FROM Report r WHERE r.idUser = :idUser"),
    @NamedQuery(name = "Report.findByNoidung", query = "SELECT r FROM Report r WHERE r.noidung = :noidung"),
    @NamedQuery(name = "Report.findByThoigian", query = "SELECT r FROM Report r WHERE r.thoigian = :thoigian")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idreport")
    private Integer idreport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "noidung")
    private String noidung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigian;
    @JoinColumn(name = "id_user_report", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUserReport;

    public Report() {
    }

    public Report(Integer idreport) {
        this.idreport = idreport;
    }

    public Report(Integer idreport, int idUser, String noidung, Date thoigian) {
        this.idreport = idreport;
        this.idUser = idUser;
        this.noidung = noidung;
        this.thoigian = thoigian;
    }

    public Integer getIdreport() {
        return idreport;
    }

    public void setIdreport(Integer idreport) {
        this.idreport = idreport;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public User getIdUserReport() {
        return idUserReport;
    }

    public void setIdUserReport(User idUserReport) {
        this.idUserReport = idUserReport;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreport != null ? idreport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.idreport == null && other.idreport != null) || (this.idreport != null && !this.idreport.equals(other.idreport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Report[ idreport=" + idreport + " ]";
    }
    
}
