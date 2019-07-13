/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoImpl;

import com.amer.common.daoInt.ProductDaoI;
import com.amer.common.entity.Product;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public class ProductDaoImpl extends AbstractDaoImpl<Product> implements ProductDaoI {

    @Override
    public List<Product> retrieveAllByName(String name) {
        
        return super.retrieveAllByProperty("product","name", name);
    }
    
    public void update(Product product)
    {
        String updateQuery = "update product set name = ?, description = ?, manufacturing_name = ?, manufacturing_date = ?, expiration_date = ?, seller_id = ?, quantity = ?, offered_date = ?, finish_date = ? where id = ?";
        Object[] updateQueryParameters = new Object[]{product.getName(), product.getDescription(), product.getManufacturingName(),
            product.getManufacturingDate(), product.getExpirationDate(), product.getSeller().getId(), 
            product.getQuantity(), product.getOfferedDate(), product.getFinishDate(), product.getId()};
        super.update(updateQuery, updateQueryParameters);
    }
    
}
