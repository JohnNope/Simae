/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author John F. Nope
 */
@Entity
@Table(name = "estadoscontrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadocontrato.findAll", query = "SELECT e FROM Estadocontrato e")
    , @NamedQuery(name = "Estadocontrato.findByCodigoEstadoContrato", query = "SELECT e FROM Estadocontrato e WHERE e.codigoEstadoContrato = :codigoEstadoContrato")
    , @NamedQuery(name = "Estadocontrato.findByEstado", query = "SELECT e FROM Estadocontrato e WHERE e.estado = :estado")})
public class Estadocontrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoEstadoContrato")
    private Integer codigoEstadoContrato;
    @Size(max = 25)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEstadoContrato", fetch = FetchType.LAZY)
    private List<Contrato> contratos;

    public Estadocontrato() {
    }

    public Estadocontrato(Integer codigoEstadoContrato) {
        this.codigoEstadoContrato = codigoEstadoContrato;
    }

    public Estadocontrato(Integer codigoEstadoContrato, String descripcion) {
        this.codigoEstadoContrato = codigoEstadoContrato;
        this.descripcion = descripcion;
    }

    public Integer getCodigoEstadoContrato() {
        return codigoEstadoContrato;
    }

    public void setCodigoEstadoContrato(Integer codigoEstadoContrato) {
        this.codigoEstadoContrato = codigoEstadoContrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEstadoContrato != null ? codigoEstadoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocontrato)) {
            return false;
        }
        Estadocontrato other = (Estadocontrato) object;
        if ((this.codigoEstadoContrato == null && other.codigoEstadoContrato != null) || (this.codigoEstadoContrato != null && !this.codigoEstadoContrato.equals(other.codigoEstadoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + estado;
    }
    
}
