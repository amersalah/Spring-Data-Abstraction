/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.data.daoI;

import com.amer.common.entity.BuyerBidProduct;
import com.amer.common.entity.Category;
import com.amer.common.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Aly
 */
public interface ProductDaoI extends CrudRepository<Product, Integer>{
    
    @Query(value="from Product p where ?1 member of p.categories")
    List<Product> findAllByCategories(Category category);
    
    
    @Query(value="from BuyerBidProduct p where p.product = ?1")
    List<BuyerBidProduct> findBidsInProduct(Optional<Product> product);
    
    @Query(value="select sum(b.amount * b.quantity) from BuyerBuyProduct b where b.product=?1")
    int calculateSumForProduct(Optional<Product> product);
    
}
