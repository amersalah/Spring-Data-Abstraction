/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.rowmappers;

import com.amer.common.entity.BuyerBidProduct;
import com.amer.common.entity.BuyerBidProductId;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Islam El-Rougy
 */
public class BuyerBidProductRowMapper implements RowMapper<BuyerBidProduct>
{

    @Override
    public BuyerBidProduct mapRow(ResultSet resultSet, int rowNumber) throws SQLException
    {
        BuyerBidProduct buyerBidProduct = new BuyerBidProduct();
        BuyerBidProductId buyerBidProductId = new BuyerBidProductId(resultSet.getInt(1), resultSet.getInt(2));
        buyerBidProduct.setId(buyerBidProductId);
        buyerBidProduct.setDate(resultSet.getDate(3));
        buyerBidProduct.setAmount(resultSet.getInt(4));
        buyerBidProduct.setQuantity(resultSet.getInt(5));
        return buyerBidProduct;
    }
        
    
}
