/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jpa.daoImpl;

import com.amer.common.daoInt.AbstractDaoI;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
  
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public long countAllRecords() {
        
        String queryString = "select count(u) from "+ getClassName()+ " u";
        Query query = getEntityManager().createQuery(queryString);
        return (long) query.getSingleResult();
    }

    @Override
    public List<Entity> retriveAllRecords() {
        
        String queryString = "from "+ getClassName()+ " u";
        List<Entity> result = (List<Entity>) getEntityManager().createQuery(queryString).getResultList();
        return result;
    }


    @Transactional
    @Override
    public Entity persistRecord(Entity entity) {
        
        getEntityManager().persist(entity);
        return entity;

    }

    @Transactional
    @Override
    public void updateRecord(Entity entity) {
        
        getEntityManager().merge(entity);
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
        
        getEntityManager().remove(entity);
    }

    @Override
    public Entity retrieveRecordBasedID(int id) {
        
        Entity entity = (Entity) getEntityManager().find(getEntityClass(),id);
        return entity;
    }
    
}
