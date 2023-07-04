package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.ProductProperties;
import com.hitwh.onlinestore.bean.Property;
import com.hitwh.onlinestore.dao.PropertyDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PropertyDAOImpl implements PropertyDAO {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Property> getPropertyByCategoryId(Integer categoryId) {
        try {
            String sql = "select * from property where cid = ?";
            return template.query(sql, new BeanPropertyRowMapper<>(Property.class), categoryId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ProductProperties> getPropertiesByProductId(int id) {
        String sql = "SELECT" +
                " COALESCE(id, '') AS id," +
                " COALESCE(pid, '') AS pid," +
                " COALESCE(ptid, '') AS ptid," +
                " COALESCE(name, '') AS name," +
                " COALESCE(value, '') AS value" +
                " FROM product_properties_view" +
                " WHERE pid = ?;";
        try {
            return template.query(sql, new BeanPropertyRowMapper<>(ProductProperties.class), id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean addProperty(int cid, String name) {
        String sql = "insert into property(cid,name) values(?,?)";

        try {
            template.update(sql, cid, name);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean changeProperty(int id, String value) {
        String sql = "UPDATE property_value SET value = ? WHERE id=?";
        int count = template.update(sql,value,id);
        return count == 1;
    }

    @Override
    public boolean addProductProperty(int id, int ptid,String value) {
        String sql = "insert into property_value(pid,ptid,value) values(?,?,?)";
        System.out.println(id+"___"+ptid+"___"+value);
        try {
            template.update(sql, id, ptid,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
