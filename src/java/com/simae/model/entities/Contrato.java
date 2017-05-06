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
import javax.persistence.JoinTable;
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
@Table(name = "contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")
    , @NamedQuery(name = "Contrato.findByCodigoContrato", query = "SELECT c FROM Contrato c WHERE c.codigoContrato = :codigoContrato")
    , @NamedQuery(name = "Contrato.findByFechaInicio", query = "SELECT c FROM Contrato c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Contrato.findByFechaFin", query = "SELECT c FROM Contrato c WHERE c.fechaFin = :fechaFin")
    , @NamedQuery(name = "Contrato.findByCantidadEquiposAlquilados", query = "SELECT c FROM Contrato c WHERE c.cantidadEquiposAlquilados = :cantidadEquiposAlquilados")
    , @NamedQuery(name = "Contrato.findByCostoAlquiler", query = "SELECT c FROM Contrato c WHERE c.costoAlquiler = :costoAlquiler")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoContrato")
    private Integer codigoContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CantidadEquiposAlquilados")
    private int cantidadEquiposAlquilados;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CostoAlquiler")
    private double costoAlquiler;
    @JoinTable(name = "equiposcontratos", joinColumns = {
        @JoinColumn(name = "CodigoContrato", referencedColumnName = "CodigoContrato")}, inverseJoinColumns = {
        @JoinColumn(name = "MatriculaEquipo", referencedColumnName = "Matricula")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Equipo> equipos;
    @JoinColumn(name = "CodigoEstadoContrato", referencedColumnName = "CodigoEstadoContrato")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estadocontrato codigoEstadoContrato;

    public Contrato() {
    }

    public Contrato(Integer codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Contrato(Integer codigoContrato, Date fechaInicio, Date fechaFin, int cantidadEquiposAlquilados, double costoAlquiler) {
        this.codigoContrato = codigoContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadEquiposAlquilados = cantidadEquiposAlquilados;
        this.costoAlquiler = costoAlquiler;
    }

    public Integer getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(Integer codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidadEquiposAlquilados() {
        return cantidadEquiposAlquilados;
    }

    public void setCantidadEquiposAlquilados(int cantidadEquiposAlquilados) {
        this.cantidadEquiposAlquilados = cantidadEquiposAlquilados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoAlquiler() {
        return costoAlquiler;
    }

    public void setCostoAlquiler(double costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
    }

    @XmlTransient
    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Estadocontrato getCodigoEstadoContrato() {
        return codigoEstadoContrato;
    }

    public void setCodigoEstadoContrato(Estadocontrato codigoEstadoContrato) {
        this.codigoEstadoContrato = codigoEstadoContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoContrato != null ? codigoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.codigoContrato == null && other.codigoContrato != null) || (this.codigoContrato != null && !this.codigoContrato.equals(other.codigoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simae.model.entities.Contrato[ codigoContrato=" + codigoContrato + " ]";
    }
    
}
