/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.data.daoI;

import com.amer.common.entity.Buyer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Aly
 */
public interface BuyerDaoI extends CrudRepository<Buyer, Integer> {
    
}
