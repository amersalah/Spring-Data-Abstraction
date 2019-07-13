/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.common.daoInt;

import com.amer.common.entity.Buyer;
import com.amer.common.entity.BuyerBidProduct;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public interface BuyerBidProductDaoI extends AbstractDaoI<BuyerBidProduct>{
    
    public List<BuyerBidProduct> retrieveAllByBuyerID(Buyer buyer);
    
}
