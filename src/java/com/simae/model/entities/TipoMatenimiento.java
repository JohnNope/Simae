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
@Table(name = "tiposdematenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMatenimiento.findAll", query = "SELECT t FROM TipoMatenimiento t")
    , @NamedQuery(name = "TipoMatenimiento.findByCodigoTipoMantenimiento", query = "SELECT t FROM TipoMatenimiento t WHERE t.codigoTipoMantenimiento = :codigoTipoMantenimiento")
    , @NamedQuery(name = "TipoMatenimiento.findByNombreTipoMantenimiento", query = "SELECT t FROM TipoMatenimiento t WHERE t.nombreTipoMantenimiento = :nombreTipoMantenimiento")})
public class TipoMatenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoTipoMantenimiento")
    private Integer codigoTipoMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NombreTipoMantenimiento")
    private String nombreTipoMantenimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoMantenimiento", fetch = FetchType.LAZY)
    private List<Mantenimientos> mantenimientos;

    public TipoMatenimiento() {
    }

    public TipoMatenimiento(Integer codigoTipoMantenimiento) {
        this.codigoTipoMantenimiento = codigoTipoMantenimiento;
    }

    public TipoMatenimiento(Integer codigoTipoMantenimiento, String nombreTipoMantenimiento) {
        this.codigoTipoMantenimiento = codigoTipoMantenimiento;
        this.nombreTipoMantenimiento = nombreTipoMantenimiento;
    }

    public Integer getCodigoTipoMantenimiento() {
        return codigoTipoMantenimiento;
    }

    public void setCodigoTipoMantenimiento(Integer codigoTipoMantenimiento) {
        this.codigoTipoMantenimiento = codigoTipoMantenimiento;
    }

    public String getNombreTipoMantenimiento() {
        return nombreTipoMantenimiento;
    }

    public void setNombreTipoMantenimiento(String nombreTipoMantenimiento) {
        this.nombreTipoMantenimiento = nombreTipoMantenimiento;
    }

    @XmlTransient
    public List<Mantenimientos> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<Mantenimientos> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoMantenimiento != null ? codigoTipoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMatenimiento)) {
            return false;
        }
        TipoMatenimiento other = (TipoMatenimiento) object;
        if ((this.codigoTipoMantenimiento == null && other.codigoTipoMantenimiento != null) || (this.codigoTipoMantenimiento != null && !this.codigoTipoMantenimiento.equals(other.codigoTipoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+nombreTipoMantenimiento;
    }
    
}
