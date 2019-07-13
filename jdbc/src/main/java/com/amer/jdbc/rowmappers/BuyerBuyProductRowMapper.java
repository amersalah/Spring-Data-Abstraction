/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.rowmappers;

import com.amer.common.entity.BuyerBuyProduct;
import com.amer.common.entity.BuyerBuyProductId;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Islam El-Rougy
 */
public class BuyerBuyProductRowMapper implements RowMapper<BuyerBuyProduct>
{

    @Override
    public BuyerBuyProduct mapRow(ResultSet resultSet, int rowNumber) throws SQLException
    {
        BuyerBuyProduct buyerBuyProduct = new BuyerBuyProduct();
        BuyerBuyProductId buyerBuyProductId = new BuyerBuyProductId(resultSet.getInt(1), resultSet.getInt(2));
        buyerBuyProduct.setId(buyerBuyProductId);
        buyerBuyProduct.setPaymentDate(resultSet.getDate(3));
        buyerBuyProduct.setAmount(resultSet.getInt(4));
        buyerBuyProduct.setQuantity(resultSet.getInt(5));
        return buyerBuyProduct;
    }
            
}
