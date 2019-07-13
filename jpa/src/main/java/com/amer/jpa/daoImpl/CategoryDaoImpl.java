/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jpa.daoImpl;

import com.amer.common.daoInt.CategoryDaoI;
import com.amer.common.entity.Category;
import com.amer.common.entity.User;
import java.util.List;
import javax.persistence.Query;


/**
 *
 * @author Aly
 */
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDaoI {

    @Override
    public List<Category> retrieveAllByValue(String value) {
        
        Query query = getEntityManager().createQuery("SELECT c FROM Category c WHERE c.value=:value");
        query.setParameter("value", value);
        List<Category> categorys = query.getResultList();
        return categorys;
        
    }
    
}
