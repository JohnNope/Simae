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
import javax.persistence.ManyToMany;
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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdentificacionRol", query = "SELECT r FROM Rol r WHERE r.identificacionRol = :identificacionRol")
    , @NamedQuery(name = "Rol.findByNombreRol", query = "SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdentificacionRol")
    private Integer identificacionRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NombreRol")
    private String nombreRol;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Permiso> permisos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    public Rol() {
    }

    public Rol(Integer identificacionRol) {
        this.identificacionRol = identificacionRol;
    }

    public Rol(Integer identificacionRol, String nombreRol) {
        this.identificacionRol = identificacionRol;
        this.nombreRol = nombreRol;
    }

    public Integer getIdentificacionRol() {
        return identificacionRol;
    }

    public void setIdentificacionRol(Integer identificacionRol) {
        this.identificacionRol = identificacionRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @XmlTransient
    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    @XmlTransient
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacionRol != null ? identificacionRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.identificacionRol == null && other.identificacionRol != null) || (this.identificacionRol != null && !this.identificacionRol.equals(other.identificacionRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+nombreRol;
    }
    
}
