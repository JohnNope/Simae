/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John F. Nope
 */
@Entity
@Table(name = "operarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operario.findAll", query = "SELECT o FROM Operario o")
    , @NamedQuery(name = "Operario.findByCodigoOperario", query = "SELECT o FROM Operario o WHERE o.codigoOperario = :codigoOperario")
    , @NamedQuery(name = "Operario.findByFechaDeAsignacionEquipo", query = "SELECT o FROM Operario o WHERE o.fechaDeAsignacionEquipo = :fechaDeAsignacionEquipo")})
public class Operario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoOperario")
    private Integer codigoOperario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaDeAsignacionEquipo")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAsignacionEquipo;
    @JoinColumn(name = "MatriculaEquipo", referencedColumnName = "Matricula")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Equipo matriculaEquipo;
    @JoinColumn(name = "NumeroDeDocumento", referencedColumnName = "NumeroDeDocumento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario numeroDeDocumento;

    public Operario() {
    }

    public Operario(Integer codigoOperario) {
        this.codigoOperario = codigoOperario;
    }

    public Operario(Integer codigoOperario, Date fechaDeAsignacionEquipo) {
        this.codigoOperario = codigoOperario;
        this.fechaDeAsignacionEquipo = fechaDeAsignacionEquipo;
    }

    public Integer getCodigoOperario() {
        return codigoOperario;
    }

    public void setCodigoOperario(Integer codigoOperario) {
        this.codigoOperario = codigoOperario;
    }

    public Date getFechaDeAsignacionEquipo() {
        return fechaDeAsignacionEquipo;
    }

    public void setFechaDeAsignacionEquipo(Date fechaDeAsignacionEquipo) {
        this.fechaDeAsignacionEquipo = fechaDeAsignacionEquipo;
    }

    public Equipo getMatriculaEquipo() {
        return matriculaEquipo;
    }

    public void setMatriculaEquipo(Equipo matriculaEquipo) {
        this.matriculaEquipo = matriculaEquipo;
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
        hash += (codigoOperario != null ? codigoOperario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operario)) {
            return false;
        }
        Operario other = (Operario) object;
        if ((this.codigoOperario == null && other.codigoOperario != null) || (this.codigoOperario != null && !this.codigoOperario.equals(other.codigoOperario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + codigoOperario ;
    }
    
}
