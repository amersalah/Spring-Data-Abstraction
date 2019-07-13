/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jpa.daoImpl;

import com.amer.common.daoInt.BuyerBuyProductDaoI;
import com.amer.common.entity.BuyerBidProduct;
import com.amer.common.entity.BuyerBuyProduct;
import com.amer.common.entity.Product;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Amer Salah
 */
public class BuyerBuyProductDaoImpl extends AbstractDao<BuyerBuyProduct> implements BuyerBuyProductDaoI  {

    @Override
    public List<BuyerBuyProduct> retrieveAllByProductId(Product product) {
        
        Query query = getEntityManager().createQuery("SELECT b FROM BuyerBuyProduct b WHERE b.product_id=:product_id");
        query.setParameter("product_id", product.getId());
        List<BuyerBuyProduct> buyProducts = query.getResultList();
        return buyProducts;
    }
    
}
