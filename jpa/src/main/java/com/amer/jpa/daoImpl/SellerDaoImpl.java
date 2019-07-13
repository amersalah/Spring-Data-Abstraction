/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jpa.daoImpl;

import com.amer.common.daoInt.SellerDaoI;
import com.amer.common.entity.Seller;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Amer Salah
 */
public class SellerDaoImpl extends AbstractDao<Seller> implements SellerDaoI {

    @Override
    public List<Seller> retrieveAllByValue(String value) {
        
        Query query = getEntityManager().createQuery("SELECT s FROM Seller s WHERE s.value=:value");
        query.setParameter("value", value);
        List<Seller> sellers = query.getResultList();
        return sellers;
    }
    
}
