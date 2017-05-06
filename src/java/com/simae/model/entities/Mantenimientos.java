/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John F. Nope
 */
@Entity
@Table(name = "mantenimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimientos.findAll", query = "SELECT m FROM Mantenimientos m")
    , @NamedQuery(name = "Mantenimientos.findByCodigoMantenimiento", query = "SELECT m FROM Mantenimientos m WHERE m.codigoMantenimiento = :codigoMantenimiento")
    , @NamedQuery(name = "Mantenimientos.findByFechaMantenimiento", query = "SELECT m FROM Mantenimientos m WHERE m.fechaMantenimiento = :fechaMantenimiento")
    , @NamedQuery(name = "Mantenimientos.findByPiezasCambiadas", query = "SELECT m FROM Mantenimientos m WHERE m.piezasCambiadas = :piezasCambiadas")})
public class Mantenimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoMantenimiento")
    private Integer codigoMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaMantenimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaMantenimiento;
    @Size(max = 255)
    @Column(name = "PiezasCambiadas")
    private String piezasCambiadas;
    @Lob
    @Size(max = 16777215)
    @Column(name = "ObservacionDeRevision")
    private String observacionDeRevision;
    @ManyToMany(mappedBy = "mantenimientosList", fetch = FetchType.LAZY)
    private List<Equipo> equipos;
    @JoinColumn(name = "codigoTipoMantenimiento", referencedColumnName = "CodigoTipoMantenimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMatenimiento codigoTipoMantenimiento;
    @JoinColumn(name = "NumeroDeDocumento", referencedColumnName = "NumeroDeDocumento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario numeroDeDocumento;

    public Mantenimientos() {
    }

    public Mantenimientos(Integer codigoMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
    }

    public Mantenimientos(Integer codigoMantenimiento, Date fechaMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public Integer getCodigoMantenimiento() {
        return codigoMantenimiento;
    }

    public void setCodigoMantenimiento(Integer codigoMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getPiezasCambiadas() {
        return piezasCambiadas;
    }

    public void setPiezasCambiadas(String piezasCambiadas) {
        this.piezasCambiadas = piezasCambiadas;
    }

    public String getObservacionDeRevision() {
        return observacionDeRevision;
    }

    public void setObservacionDeRevision(String observacionDeRevision) {
        this.observacionDeRevision = observacionDeRevision;
    }

    @XmlTransient
    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public TipoMatenimiento getCodigoTipoMantenimiento() {
        return codigoTipoMantenimiento;
    }

    public void setCodigoTipoMantenimiento(TipoMatenimiento codigoTipoMantenimiento) {
        this.codigoTipoMantenimiento = codigoTipoMantenimiento;
    }

    public Usuario getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(Usuario numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMantenimiento != null ? codigoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimientos)) {
            return false;
        }
        Mantenimientos other = (Mantenimientos) object;
        if ((this.codigoMantenimiento == null && other.codigoMantenimiento != null) || (this.codigoMantenimiento != null && !this.codigoMantenimiento.equals(other.codigoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + codigoMantenimiento;
    }
    
}
