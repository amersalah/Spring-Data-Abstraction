/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoImpl;

import com.amer.common.daoInt.SellerDaoI;
import com.amer.common.entity.Seller;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public class SellerDaoImpl extends AbstractDaoImpl<Seller> implements SellerDaoI {

    @Override
    public List<Seller> retrieveAllByValue(String value) {
        
        return super.retrieveAllByProperty("seller", "value", value);    
    }
    
    public void update(Seller seller)
    {
        String updateQuery = "update seller set value = ? where id = ?";
        Object[] updateQueryParameters = new Object[]{seller.getValue(), seller.getId()};
        super.update(updateQuery, updateQueryParameters);
    }    
    
    
    
}
