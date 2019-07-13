/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoI;

import com.amer.common.entity.BuyerBidProduct;
import com.amer.common.entity.BuyerBidProductId;

/**
 *
 * @author Aly
 */
public interface BuyerBidProductDaoI extends com.amer.common.daoInt.BuyerBidProductDaoI{
    
    public void update(BuyerBidProduct buyerBidProduct);
    public BuyerBidProduct retrieve(BuyerBidProductId id);
    public BuyerBidProduct insert(BuyerBidProduct buyerBidProduct);
    public void deleteById(BuyerBidProductId id);
    public void delete(BuyerBidProduct buyerBidProduct);
    
}
