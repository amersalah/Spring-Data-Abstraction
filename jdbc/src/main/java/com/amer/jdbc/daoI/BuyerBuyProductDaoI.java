/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoI;

import com.amer.common.entity.BuyerBuyProduct;
import com.amer.common.entity.BuyerBuyProductId;

/**
 *
 * @author Amer Salah
 */
public interface BuyerBuyProductDaoI extends com.amer.common.daoInt.BuyerBuyProductDaoI {
    
    public void update(BuyerBuyProduct buyerBuyProduct);
    public BuyerBuyProduct retrieve(BuyerBuyProductId id);
    public BuyerBuyProduct insert(BuyerBuyProduct buyerBuyProduct);
    public void deleteById(BuyerBuyProductId id);
    public void delete(BuyerBuyProduct buyerBuyProduct);


    
}
