/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.hibernate.daoImpl;

import com.amer.common.daoInt.BuyerBuyProductDaoI;
import com.amer.common.entity.BuyerBuyProduct;
import com.amer.common.entity.Product;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public class BuyerBuyProductDaoImpl extends AbstractDao<BuyerBuyProduct> implements BuyerBuyProductDaoI{

    @Override
    public List<BuyerBuyProduct> retrieveAllByProductId(Product product) {
        String queryString = "from BuyerBidProduct where product_id = :id";
        List<BuyerBuyProduct> products = (List<BuyerBuyProduct>) getHibernateTemplate().findByNamedParam(queryString, "product_id", product.getId());
        return products;
    }
    
}
