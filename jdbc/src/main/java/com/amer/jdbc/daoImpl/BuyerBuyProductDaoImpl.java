/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoImpl;

import com.amer.jdbc.daoI.BuyerBuyProductDaoI;
import com.amer.common.entity.BuyerBuyProduct;
import com.amer.common.entity.BuyerBuyProductId;
import com.amer.common.entity.Product;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 *
 * @author Aly
 */
public class BuyerBuyProductDaoImpl extends AbstractDaoImpl<BuyerBuyProduct> implements BuyerBuyProductDaoI {

    
    @Override
    public List<BuyerBuyProduct> retrieveAllByProductId(Product product) {

        return super.getAll("buyer_buy_product");
    }

    @Override
    public void update(BuyerBuyProduct buyerBuyProduct) {
        int buyerId = buyerBuyProduct.getId().getBuyerId();
        int productId = buyerBuyProduct.getId().getProductId();
        Object[] updateQueryParameters = new Object[]{buyerBuyProduct.getPaymentDate(), buyerBuyProduct.getAmount(), buyerBuyProduct.getQuantity(), buyerId, productId};
        String updateQuery = "update buyer_buy_product set payment_date = ?, amount = ?, quantity = ? "
                + "where buyer_id = ? and product_id = ?";
        super.update(updateQuery, updateQueryParameters);
    }

    public void initialize() {
        simpleJdbcInsert.withTableName("buyer_buy_product");
    }

    @Override
    public BuyerBuyProduct retrieve(BuyerBuyProductId id)
    {
        Map<String, String> queryParameters = new LinkedHashMap<>();
        queryParameters.put("tableName", "buyer_buy_product");
        queryParameters.put("buyer_id", String.valueOf(id.getBuyerId()));
        queryParameters.put("product_id", String.valueOf(id.getProductId()));
        return super.get(queryParameters);
    }
    
    @Override
    public BuyerBuyProduct insert(BuyerBuyProduct buyerBuyProduct)
    {
        SqlParameterSource parameters = new MapSqlParameterSource().
                addValue("buyer_id", buyerBuyProduct.getId().getBuyerId()).
                addValue("product_id", buyerBuyProduct.getId().getProductId()).
                addValue("payment_date", buyerBuyProduct.getPaymentDate()).
                addValue("amount", buyerBuyProduct.getAmount()).
                addValue("quantity", buyerBuyProduct.getQuantity());
        simpleJdbcInsert.execute(parameters);
        return buyerBuyProduct;
    }
    
    

    @Override
    public void deleteById(BuyerBuyProductId id)
    {
        Map<String, String> queryParameters = new LinkedHashMap<>();
        queryParameters.put("tableName", "buyer_buy_product");
        queryParameters.put("buyer_id", String.valueOf(id.getBuyerId()));
        queryParameters.put("product_id", String.valueOf(id.getProductId()));
        super.remove(queryParameters);
    }

    @Override
    public void delete(BuyerBuyProduct buyerBuyProduct)
    {
        BuyerBuyProductId id = buyerBuyProduct.getId();
        Map<String, String> queryParameters = new LinkedHashMap<>();
        queryParameters.put("tableName", "buyer_buy_product");
        queryParameters.put("buyer_id", String.valueOf(id.getBuyerId()));
        queryParameters.put("product_id", String.valueOf(id.getProductId()));
        super.remove(queryParameters);
    }

    
    
}
