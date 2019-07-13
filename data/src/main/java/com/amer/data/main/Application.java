/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.data.main;

import com.amer.common.entity.BuyerBidProduct;
import com.amer.common.entity.Category;
import com.amer.common.entity.Product;
import com.amer.common.entity.User;
import com.amer.data.daoI.CategoryDaoI;
import com.amer.data.daoI.ProductDaoI;
import com.amer.data.daoI.UserDaoI;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Amer Salah
 */
public class Application {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
        
        ProductDaoI productDao = (ProductDaoI)context.getBean("productDaoI");
        
        
        //Query One
        
//        Category category = new Category();
//        category.setId(4);
//        category.setDescription("FFFFFFFFFFF");
//        category.setValue("fffffff");
//                
//        
//        List<Product> products= productDao.findAllByCategories(category);
//        System.out.println(products.get(0).getDescription());

        
          //Query Two
//          
    //      Optional<Product> product =  productDao.findById(3);
//          
//          
//         List<BuyerBidProduct>bids=  productDao.findBidsInProduct(product);
//         System.out.println(bids.size());
        


        //Query Three
        Optional<Product> product =  productDao.findById(1);
        System.out.println(productDao.calculateSumForProduct(product));
        

        
    }
    
}
