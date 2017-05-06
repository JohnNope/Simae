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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByIdentificacionPermiso", query = "SELECT p FROM Permiso p WHERE p.identificacionPermiso = :identificacionPermiso")
    , @NamedQuery(name = "Permiso.findByNombre", query = "SELECT p FROM Permiso p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Permiso.findByUrl", query = "SELECT p FROM Permiso p WHERE p.url = :url")
    , @NamedQuery(name = "Permiso.findByIcono", query = "SELECT p FROM Permiso p WHERE p.icono = :icono")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdentificacionPermiso")
    private Integer identificacionPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Url")
    private String url;
    @Size(max = 45)
    @Column(name = "Icono")
    private String icono;
    @JoinTable(name = "rolpermiso", joinColumns = {
        @JoinColumn(name = "IdentificacionPermiso", referencedColumnName = "IdentificacionPermiso")}, inverseJoinColumns = {
        @JoinColumn(name = "IdentificacionRol", referencedColumnName = "IdentificacionRol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPermisoPadre", fetch = FetchType.LAZY)
    private List<Permiso> permisos;
    @JoinColumn(name = "IdPermisoPadre", referencedColumnName = "IdentificacionPermiso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permiso idPermisoPadre;

    public Permiso() {
    }

    public Permiso(Integer identificacionPermiso) {
        this.identificacionPermiso = identificacionPermiso;
    }

    public Permiso(Integer identificacionPermiso, String nombre) {
        this.identificacionPermiso = identificacionPermiso;
        this.nombre = nombre;
    }

    public Integer getIdentificacionPermiso() {
        return identificacionPermiso;
    }

    public void setIdentificacionPermiso(Integer identificacionPermiso) {
        this.identificacionPermiso = identificacionPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @XmlTransient
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @XmlTransient
    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public Permiso getIdPermisoPadre() {
        return idPermisoPadre;
    }

    public void setIdPermisoPadre(Permiso idPermisoPadre) {
        this.idPermisoPadre = idPermisoPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacionPermiso != null ? identificacionPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.identificacionPermiso == null && other.identificacionPermiso != null) || (this.identificacionPermiso != null && !this.identificacionPermiso.equals(other.identificacionPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + nombre + "";
    }
    
}
