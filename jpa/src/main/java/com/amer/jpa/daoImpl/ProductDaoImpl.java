/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jpa.daoImpl;

import com.amer.common.daoInt.ProductDaoI;
import com.amer.common.entity.Product;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Amer Salah
 */
public class ProductDaoImpl  extends AbstractDao<Product> implements ProductDaoI{

    @Override
    public List<Product> retrieveAllByName(String name) {
        
        Query query = getEntityManager().createQuery("SELECT p FROM Product p WHERE p.name=:name");
        query.setParameter("name", name);
        List<Product> products = query.getResultList();
        return products;
    }
    
}
