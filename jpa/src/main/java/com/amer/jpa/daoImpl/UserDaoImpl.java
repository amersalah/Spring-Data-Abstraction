/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jpa.daoImpl;

import com.amer.common.daoInt.UserDaoI;
import com.amer.common.entity.User;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Amer Sslah
 */
public class UserDaoImpl extends AbstractDao<User> implements UserDaoI {

    @Override
    public List<User> retrieveAllByAddress(String address) {

        Query query = getEntityManager().createQuery("SELECT u FROM User u WHERE u.address=:address");
        query.setParameter("address", address);
        List<User> users = query.getResultList();
        return users;
    }

}
