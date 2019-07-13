/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jpa.main;

import com.amer.common.daoInt.UserDaoI;
import com.amer.common.entity.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Amer Salah
 */
public class Application {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        UserDaoI daoImpl = (UserDaoI)context.getBean("userdao");
        List<User> users = daoImpl.retrieveAllByAddress("Cairo");
        System.out.println(users.size());
        
    }
    
}
