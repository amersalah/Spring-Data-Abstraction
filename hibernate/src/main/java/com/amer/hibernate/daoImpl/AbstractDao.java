/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.hibernate.daoImpl;

import com.amer.common.daoInt.AbstractDaoI;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amer Salah
 */
public class AbstractDao<Entity> implements AbstractDaoI<Entity>{
    
    public AbstractDao(){}
            
    private Class<Entity> getEntityClass()
    {
        return (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).
                getActualTypeArguments()[0];
    }
    
    private String getClassName()
    {
        return getEntityClass().getSimpleName();
    }
  
    
    private HibernateTemplate hibernateTemplate;

    
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    
    @Override
    public long countAllRecords() {
        
        String queryString = "select count(u) from "+ getClassName()+ " u";
        List result = getHibernateTemplate().find(queryString);
        return (long) result.get(0);
    }

    @Override
    public List<Entity> retriveAllRecords() {
        
        String queryString = "from "+ getClassName()+ " u";
        List<Entity> result = (List<Entity>) getHibernateTemplate().find(queryString);
        return result;
    }


    @Transactional
    @Override
    public Entity persistRecord(Entity entity) {
        
        hibernateTemplate.persist(entity);
        return entity;

    }

    @Transactional
    @Override
    public void updateRecord(Entity entity) {
        
        hibernateTemplate.update(entity);
    }

    @Transactional
    @Override
    public void deleteRecordByID(int id) {
        
        Entity entity = retrieveRecordBasedID(id);
        deleteRecord(entity);
    }

    @Transactional
    @Override
    public void deleteRecord(Entity entity) {
        
        hibernateTemplate.delete(entity);
    }

    @Override
    public Entity retrieveRecordBasedID(int id) {
        
        Entity entity = (Entity) hibernateTemplate.get(getEntityClass(),id);
        return entity;
    }
    
}
