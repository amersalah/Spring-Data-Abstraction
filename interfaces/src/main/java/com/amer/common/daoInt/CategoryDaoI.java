/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.common.daoInt;

import com.amer.common.entity.Category;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public interface CategoryDaoI extends AbstractDaoI<Category> {
    
    public List<Category> retrieveAllByValue(String value);
}
