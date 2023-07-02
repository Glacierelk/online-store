package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.ShoppingCart;
import com.hitwh.onlinestore.dao.ShoppingCartDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<ShoppingCart> queryByUserId(Integer userId) {
        String sql = "select * from shopping_cart where uid = ? and status = 1";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ShoppingCart.class), userId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean addGoods(ShoppingCart shoppingCart) {
        String sql = "INSERT INTO shopping_cart(pid,count,uid,status) VALUES(?,?,?,?)";
        try{
            jdbcTemplate.update(sql,shoppingCart.getPid(),shoppingCart.getCount(),shoppingCart.getUid(),shoppingCart.getStatus());
            System.out.println("insert suc");
            return true;
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean deleteGoods(int id) {
        String sql="UPDATE shopping_cart SET status=0 WHERE id=? and status=1";
        try {
            return jdbcTemplate.update(sql,id) > 0;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean alterGoodsNumber(ShoppingCart shoppingCart) {
        String sql = "UPDATE shopping_cart SET count=? WHERE pid=? AND uid=? AND status=1";
        try {
            jdbcTemplate.update(sql,shoppingCart.getCount(),shoppingCart.getPid(),shoppingCart.getUid());
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public Integer getCount(int id) {
        String sql = "select count(*) from shopping_cart where uid = ? and status = 1";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class, id);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean getCartStatus(int pid, int uid) {
        String sql = "SELECT id FROM shopping_cart WHERE uid=? AND pid=? AND status=1";
        try {
            ShoppingCart shoppingCart=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(ShoppingCart.class),uid,pid);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

}
