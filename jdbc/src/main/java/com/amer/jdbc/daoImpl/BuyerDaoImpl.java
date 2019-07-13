/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoImpl;

import com.amer.common.daoInt.BuyerDaoI;
import com.amer.common.entity.Buyer;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public class BuyerDaoImpl extends AbstractDaoImpl<Buyer> implements BuyerDaoI{

    @Override
    public List<Buyer> retrieveAllByValue(String value) {
        
        return super.retrieveAllByProperty("category", "value", value);
    }
    
    public void update(Buyer buyer)
    {
        String updateQuery = "update buyer set value = ? where id = ?";
        Object[] updateQueryParameters = new Object[]{buyer.getValue(), buyer.getId()};
        super.update(updateQuery, updateQueryParameters);
    }    

    
    
}
