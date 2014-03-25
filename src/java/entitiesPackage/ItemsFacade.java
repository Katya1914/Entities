/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitiesPackage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ekaterina
 */
@Stateless
public class ItemsFacade extends AbstractFacade<Items> {
    @PersistenceContext(unitName = "EntitiesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemsFacade() {
        super(Items.class);
    }
    
}
