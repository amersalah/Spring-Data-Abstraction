/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.hibernate.daoImpl;

import com.amer.common.daoInt.CategoryDaoI;
import com.amer.common.entity.Category;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDaoI {

    @Override
    public List<Category> retrieveAllByValue(String value) {
        
        String queryString = "from Category where value = :value";
        List<Category> categorys = (List<Category>) getHibernateTemplate().findByNamedParam(queryString, "value", value);
        return categorys;
    }
    
}
