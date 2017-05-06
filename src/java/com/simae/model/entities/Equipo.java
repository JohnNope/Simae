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
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByMatricula", query = "SELECT e FROM Equipo e WHERE e.matricula = :matricula")
    , @NamedQuery(name = "Equipo.findByModelo", query = "SELECT e FROM Equipo e WHERE e.modelo = :modelo")
    , @NamedQuery(name = "Equipo.findByMarca", query = "SELECT e FROM Equipo e WHERE e.marca = :marca")
    , @NamedQuery(name = "Equipo.findByPotencia", query = "SELECT e FROM Equipo e WHERE e.potencia = :potencia")
    , @NamedQuery(name = "Equipo.findByFechaMantenimimientoProgramado", query = "SELECT e FROM Equipo e WHERE e.fechaMantenimimientoProgramado = :fechaMantenimimientoProgramado")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Potencia")
    private String potencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaMantenimimientoProgramado")
    @Temporal(TemporalType.DATE)
    private Date fechaMantenimimientoProgramado;
    @ManyToMany(mappedBy = "equipoList", fetch = FetchType.LAZY)
    private List<Contrato> contratos;
    @JoinTable(name = "equiposmantenimientos", joinColumns = {
        @JoinColumn(name = "MatriculaEquipo", referencedColumnName = "Matricula")}, inverseJoinColumns = {
        @JoinColumn(name = "CodigoMantenimiento", referencedColumnName = "CodigoMantenimiento")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Mantenimientos> mantenimientos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculaEquipo", fetch = FetchType.LAZY)
    private List<Operario> operarios;
    @JoinColumn(name = "CodigoTipoEquipo", referencedColumnName = "CodigoTipoDeEquipo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoEquipo codigoTipoEquipo;

    public Equipo() {
    }

    public Equipo(String matricula) {
        this.matricula = matricula;
    }

    public Equipo(String matricula, String modelo, String marca, String potencia, Date fechaMantenimimientoProgramado) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.potencia = potencia;
        this.fechaMantenimimientoProgramado = fechaMantenimimientoProgramado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public Date getFechaMantenimimientoProgramado() {
        return fechaMantenimimientoProgramado;
    }

    public void setFechaMantenimimientoProgramado(Date fechaMantenimimientoProgramado) {
        this.fechaMantenimimientoProgramado = fechaMantenimimientoProgramado;
    }

    @XmlTransient
    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    @XmlTransient
    public List<Mantenimientos> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<Mantenimientos> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    @XmlTransient
    public List<Operario> getOperarios() {
        return operarios;
    }

    public void setOperarios(List<Operario> operarios) {
        this.operarios = operarios;
    }

    public TipoEquipo getCodigoTipoEquipo() {
        return codigoTipoEquipo;
    }

    public void setCodigoTipoEquipo(TipoEquipo codigoTipoEquipo) {
        this.codigoTipoEquipo = codigoTipoEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return matricula + " ";
    }
    
}
