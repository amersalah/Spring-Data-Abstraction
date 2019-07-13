/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoImpl;

import com.amer.common.daoInt.CategoryDaoI;
import com.amer.common.entity.Category;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public class CategoryDaoImpl extends AbstractDaoImpl<Category> implements CategoryDaoI {

    @Override
    public List<Category> retrieveAllByValue(String value) {

        return super.retrieveAllByProperty("category", "value", value);

    }
    
    public void update(Category category)
    {
        String updateQuery = "update category set value = ?, description = ? where id = ?";
        Object[] updateQueryParameters = new Object[]{category.getValue(), category.getDescription(), category.getId()};
        super.update(updateQuery, updateQueryParameters);
    }    

}
