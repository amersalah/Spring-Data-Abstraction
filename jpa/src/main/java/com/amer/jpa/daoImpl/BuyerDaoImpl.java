/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jpa.daoImpl;

import com.amer.common.daoInt.BuyerDaoI;
import com.amer.common.entity.Buyer;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Amer Salah
 */
public class BuyerDaoImpl extends AbstractDao<Buyer> implements BuyerDaoI{
    
    @Override
    public List<Buyer> retrieveAllByValue(String value) {
        
        Query query = getEntityManager().createQuery("SELECT b FROM Buyer b WHERE b.value=:value");
        query.setParameter("value", value);
        List<Buyer> buyers = query.getResultList();
        return buyers;
        
    }

    
}
