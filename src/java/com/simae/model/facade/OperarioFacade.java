/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.model.facade;

import com.simae.model.entities.Operario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nena
 */
@Stateless
public class OperarioFacade extends AbstractFacade<Operario> {

    @PersistenceContext(unitName = "Simae_5.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperarioFacade() {
        super(Operario.class);
    }
    
}
