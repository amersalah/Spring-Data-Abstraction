/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.hibernate.daoImpl;

import com.amer.common.daoInt.ProductDaoI;
import com.amer.common.entity.Product;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public class ProductDaoImpl  extends AbstractDao<Product> implements ProductDaoI {

    @Override
    public List<Product> retrieveAllByName(String name) {
        
        String queryString = "from Product where name = :name";
        List<Product> products = (List<Product>) getHibernateTemplate().findByNamedParam(queryString, "name", name);
        return products;
        
    }
    
}
