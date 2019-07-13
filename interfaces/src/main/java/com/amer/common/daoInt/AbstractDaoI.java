/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.common.daoInt;

import java.util.List;


/**
 *
 * @author Amer Salah
 */
public interface AbstractDaoI <Entity>{
    
    public long countAllRecords();
    public List<Entity> retriveAllRecords();
    public Entity retrieveRecordBasedID(int id);
    public Entity persistRecord(Entity entity);
    public void updateRecord(Entity entity);
    public void deleteRecordByID(int id);
    public void deleteRecord(Entity entity);
    
    
}
