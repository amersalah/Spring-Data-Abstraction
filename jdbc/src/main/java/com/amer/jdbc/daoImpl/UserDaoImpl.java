/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoImpl;

import com.amer.common.daoInt.UserDaoI;
import com.amer.common.entity.User;
import java.util.List;

/**
 *
 * @author Amer Salah
 */
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDaoI {

    @Override
    public List<User> retrieveAllByAddress(String address) {
        
        return super.retrieveAllByProperty("user","address", address);
    }
    
    
    public void update(User user) {
        Object[] updateQueryParameters = new Object[]{user.getEmail(),
            user.getAddress(), user.getPhone(), user.getMobile(),
            user.getDateOfBirth(), user.getRegistrationDate(),
            user.getUserName(), user.getPassword(), user.getFullName(), user.getId()};
        String updateQuery = "update user set email = ?, address = ?, phone = ?, "
                + "mobile = ?, date_of_birth = ?, registration_date = ?, user_name = ?, "
                + "password = ?, full_name = ? where id = ?";
        super.update(updateQuery, updateQueryParameters);
    }
    
}
