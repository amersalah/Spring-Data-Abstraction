/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.hibernate.daoImpl;

import com.amer.common.daoInt.BuyerBidProductDaoI;
import com.amer.common.entity.Buyer;
import com.amer.common.entity.BuyerBidProduct;
import com.amer.common.entity.User;
import java.util.List;

/**
 *
 * @author ِAmer Salah
 */
public class BuyerBidProductDaoImpl  extends AbstractDao<BuyerBidProduct> implements BuyerBidProductDaoI{

    @Override
    public List<BuyerBidProduct> retrieveAllByBuyerID(Buyer buyer) {
        
        String queryString = "from BuyerBidProduct where buyer_id = :id";
        List<BuyerBidProduct> bids = (List<BuyerBidProduct>) getHibernateTemplate().findByNamedParam(queryString, "buyer_id", buyer.getId());
        return bids;
    }
    
    
}
