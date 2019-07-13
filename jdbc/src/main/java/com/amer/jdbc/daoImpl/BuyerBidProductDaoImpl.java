/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoImpl;

import com.amer.jdbc.daoI.BuyerBidProductDaoI;
import com.amer.common.entity.Buyer;
import com.amer.common.entity.BuyerBidProduct;
import com.amer.common.entity.BuyerBidProductId;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 *
 * @author Amer Salah
 */
public class BuyerBidProductDaoImpl extends AbstractDaoImpl<BuyerBidProduct> implements BuyerBidProductDaoI {

    @Override
    public List<BuyerBidProduct> retrieveAllByBuyerID(Buyer buyer) {
        return super.getAll("buyer_bid_product"); 
    }
    
    @Override
    public void update(BuyerBidProduct buyerBidProduct)
    {
        int buyerId = buyerBidProduct.getId().getBuyerId();
        int productId = buyerBidProduct.getId().getProductId();
        Object[] updateQueryParameters = new Object[]{buyerBidProduct.getDate(), buyerBidProduct.getAmount(), buyerBidProduct.getQuantity(), buyerId, productId};
        String updateQuery = "update buyer_buy_product set date = ?, amount = ?, quantity = ? "
                + "where buyer_id = ? and product_id = ?";
        super.update(updateQuery, updateQueryParameters);
    }
        
    public void initialize()
    {
        simpleJdbcInsert.withTableName("buyer_bid_product");
    }
    
    @Override
    public BuyerBidProduct retrieve(BuyerBidProductId id)
    {
        Map<String, String> queryParameters = new LinkedHashMap<>();
        queryParameters.put("tableName", "buyer_bid_product");
        queryParameters.put("buyer_id", String.valueOf(id.getBuyerId()));
        queryParameters.put("product_id", String.valueOf(id.getProductId()));
        return super.get(queryParameters);
    }
    
    @Override
    public BuyerBidProduct insert(BuyerBidProduct buyerBidProduct)
    {
        SqlParameterSource parameters = new MapSqlParameterSource().
                addValue("buyer_id", buyerBidProduct.getId().getBuyerId()).
                addValue("product_id", buyerBidProduct.getId().getProductId()).
                addValue("date", buyerBidProduct.getDate()).
                addValue("amount", buyerBidProduct.getAmount()).
                addValue("quantity", buyerBidProduct.getQuantity());
        simpleJdbcInsert.execute(parameters);
        return buyerBidProduct;
    }

    @Override
    public void deleteById(BuyerBidProductId id)
    {
        Map<String, String> queryParameters = new LinkedHashMap<>();
        queryParameters.put("tableName", "buyer_bid_product");
        queryParameters.put("buyer_id", String.valueOf(id.getBuyerId()));
        queryParameters.put("product_id", String.valueOf(id.getProductId()));
        super.remove(queryParameters);
    }

    @Override
    public void delete(BuyerBidProduct buyerBidProduct)
    {
        BuyerBidProductId id = buyerBidProduct.getId();
        Map<String, String> queryParameters = new LinkedHashMap<>();
        queryParameters.put("tableName", "buyer_bid_product");
        queryParameters.put("buyer_id", String.valueOf(id.getBuyerId()));
        queryParameters.put("product_id", String.valueOf(id.getProductId()));
        super.remove(queryParameters);
    }
    
}
