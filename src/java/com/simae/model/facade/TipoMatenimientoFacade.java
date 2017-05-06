/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.model.facade;

import com.simae.model.entities.TipoMatenimiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nena
 */
@Stateless
public class TipoMatenimientoFacade extends AbstractFacade<TipoMatenimiento> {

    @PersistenceContext(unitName = "Simae_5.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMatenimientoFacade() {
        super(TipoMatenimiento.class);
    }
    
}
