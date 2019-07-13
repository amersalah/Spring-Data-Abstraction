/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.jdbc.daoImpl;

import com.amer.common.daoInt.AbstractDaoI;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author Amer Salah
 */
public class AbstractDaoImpl<Entity , ID> implements AbstractDaoI<Entity> {

    protected JdbcTemplate jdbcTemplate;
    protected SimpleJdbcInsert simpleJdbcInsert;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(getTableName())
                .usingGeneratedKeyColumns("id");
    }

    private Class<Entity> getEntityClass() {
        return (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).
                getActualTypeArguments()[0];
    }

    private String getTableName() {
        return getEntityClass().getSimpleName();
    }

    private RowMapper getTableRowMapper() {
        RowMapper rowMapper = null;
        try {
            rowMapper = (RowMapper) Class.forName("com.elrougy.jdbc.dal.rowmappers." + getTableName() + "RowMapper").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rowMapper == null) {
            rowMapper = new BeanPropertyRowMapper(getEntityClass());
        }
        return rowMapper;
    }

    @Override
    public long countAllRecords() {

        String countQuery = "select count(*) from " + getTableName();
        long rowCount = jdbcTemplate.queryForObject(countQuery, Integer.class);
        return rowCount;

    }

    @Override
    public List<Entity> retriveAllRecords() {

        String retrievalQuery = "select * from " + getTableName();
        List<Entity> retrievedList = jdbcTemplate
                .query(retrievalQuery, getTableRowMapper());
        return retrievedList;

    }
    
    protected Entity get(Map<String, String> queryParameters)
    {
        List<String> keys = new ArrayList(queryParameters.keySet());
        String retrievalQuery = "select * from " + queryParameters.get("tableName") + " where " + keys.get(1) + " = ? and " + keys.get(2) + " = ?";
        Entity retrievedEntity = (Entity) jdbcTemplate.queryForObject(retrievalQuery,
                new Object[]{queryParameters.get(keys.get(1)), queryParameters.get(keys.get(2))}, getTableRowMapper());
        return retrievedEntity;
    }        

    @Override
    public Entity retrieveRecordBasedID(int id) {

        String retrievalQuery = "select * from " + getTableName() + " where id = ?";
        Entity retrievedEntity = (Entity) jdbcTemplate.queryForObject(retrievalQuery,
                new Object[]{id}, getTableRowMapper());
        return retrievedEntity;

    }

    @Override
    public Entity persistRecord(Entity entity) {

        SqlParameterSource parameters = new BeanPropertySqlParameterSource(entity);
        simpleJdbcInsert.execute(parameters);
        return entity;
    }

    protected void update(String updateQuery, Object[] updateQueryParameters) {
        jdbcTemplate.update(updateQuery, updateQueryParameters);
    }

    @Deprecated
    @Override
    public void updateRecord(Entity entity) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRecordByID(int id) {

        String deletionQuery = "delete from " + getTableName() + " where id = ?";
        Object[] deletionQueryParameters = new Object[]{id};
        jdbcTemplate.update(deletionQuery, deletionQueryParameters);

    }

    protected List<Entity> getAll(String tableName)
    {
        String retrievalQuery = "select * from " + tableName;
        List<Entity> retrievedList = jdbcTemplate
                .query(retrievalQuery, getTableRowMapper());
        return retrievedList;
    }  
    
    @Override
    public void deleteRecord(Entity entity) {

        try {
            Field field = getEntityClass().getDeclaredField("id");
            field.setAccessible(true);
            ID id = (ID) field.get(entity);
            deleteRecordByID(id);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(AbstractDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AbstractDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void remove(Map<String, String> queryParameters)
    {
        List<String> keys = new ArrayList(queryParameters.keySet());
        String deletionQuery = "delete from " + queryParameters.get("tableName") + " where " + keys.get(1) + " = ? and " + keys.get(2) + " = ?";
        Object[] deletionQueryParameters = new Object[]{queryParameters.get(keys.get(1)), queryParameters.get(keys.get(2))};
        jdbcTemplate.update(deletionQuery, deletionQueryParameters);
    }   
    

    protected List<Entity> retrieveAllByProperty(String tableName, String columnName, Object retrievalProperty) {
        String retrievalQuery = "select * from " + tableName + " where " + columnName + " = ?";
        Object[] retrievalQueryParameters = new Object[]{retrievalProperty};
        List<Entity> retrievedList = jdbcTemplate.query(retrievalQuery,
                retrievalQueryParameters, getTableRowMapper());
        return retrievedList;
    }

}
