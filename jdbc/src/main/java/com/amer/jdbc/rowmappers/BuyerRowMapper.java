/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.rowmappers;

import com.amer.common.entity.Buyer;
import com.amer.common.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Islam El-Rougy
 */
public class BuyerRowMapper implements RowMapper<Buyer>
{

    @Override
    public Buyer mapRow(ResultSet resultSet, int rowNumber) throws SQLException
    {
        Buyer buyer = new Buyer();
        buyer.setId(resultSet.getInt(1));
        buyer.setValue(resultSet.getString(2));
        User user = new User();
        user.setId(resultSet.getInt(3));
        buyer.setUser(user);
        return buyer;
    }
        
}
