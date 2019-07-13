/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.hibernate.daoImpl;

import com.amer.common.daoInt.UserDaoI;
import com.amer.common.entity.User;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public class UserDaoImpl extends AbstractDao<User> implements UserDaoI {

    //public UserDaoImpl(){super();}
    public UserDaoImpl() {
    }

    @Override
    public List<User> retrieveAllByAddress(String address) {
        String queryString = "from User where address = :address";
        List<User> users = (List<User>) getHibernateTemplate().findByNamedParam(queryString, "address", address);
        return users;
    }

}
