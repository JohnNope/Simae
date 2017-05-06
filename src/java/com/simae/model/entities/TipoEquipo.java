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
@Table(name = "tiposdeequipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEquipo.findAll", query = "SELECT t FROM TipoEquipo t")
    , @NamedQuery(name = "TipoEquipo.findByCodigoTipoDeEquipo", query = "SELECT t FROM TipoEquipo t WHERE t.codigoTipoDeEquipo = :codigoTipoDeEquipo")
    , @NamedQuery(name = "TipoEquipo.findByNombreTipoDeEquipo", query = "SELECT t FROM TipoEquipo t WHERE t.nombreTipoDeEquipo = :nombreTipoDeEquipo")})
public class TipoEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoTipoDeEquipo")
    private Integer codigoTipoDeEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NombreTipoDeEquipo")
    private String nombreTipoDeEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoEquipo", fetch = FetchType.LAZY)
    private List<Equipo> equipos;

    public TipoEquipo() {
    }

    public TipoEquipo(Integer codigoTipoDeEquipo) {
        this.codigoTipoDeEquipo = codigoTipoDeEquipo;
    }

    public TipoEquipo(Integer codigoTipoDeEquipo, String nombreTipoDeEquipo) {
        this.codigoTipoDeEquipo = codigoTipoDeEquipo;
        this.nombreTipoDeEquipo = nombreTipoDeEquipo;
    }

    public Integer getCodigoTipoDeEquipo() {
        return codigoTipoDeEquipo;
    }

    public void setCodigoTipoDeEquipo(Integer codigoTipoDeEquipo) {
        this.codigoTipoDeEquipo = codigoTipoDeEquipo;
    }

    public String getNombreTipoDeEquipo() {
        return nombreTipoDeEquipo;
    }

    public void setNombreTipoDeEquipo(String nombreTipoDeEquipo) {
        this.nombreTipoDeEquipo = nombreTipoDeEquipo;
    }

    @XmlTransient
    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoDeEquipo != null ? codigoTipoDeEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEquipo)) {
            return false;
        }
        TipoEquipo other = (TipoEquipo) object;
        if ((this.codigoTipoDeEquipo == null && other.codigoTipoDeEquipo != null) || (this.codigoTipoDeEquipo != null && !this.codigoTipoDeEquipo.equals(other.codigoTipoDeEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simae.model.entities.TipoEquipo[ codigoTipoDeEquipo=" + codigoTipoDeEquipo + " ]";
    }
    
}
