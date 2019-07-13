/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jpa.daoImpl;

import com.amer.common.daoInt.BuyerBidProductDaoI;
import com.amer.common.entity.Buyer;
import com.amer.common.entity.BuyerBidProduct;
import com.amer.common.entity.User;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Amer Salah
 */
public class BuyerBidProductDaoImpl extends AbstractDao<BuyerBidProduct> implements BuyerBidProductDaoI{

    @Override
    public List<BuyerBidProduct> retrieveAllByBuyerID(Buyer buyer) {

        Query query = getEntityManager().createQuery("SELECT b FROM BuyerBidProduct b WHERE b.buyer_id=:buyer_id");
        query.setParameter("buyer_id", buyer.getId());
        List<BuyerBidProduct> bidProducts = query.getResultList();
        return bidProducts;
    }
    
}
