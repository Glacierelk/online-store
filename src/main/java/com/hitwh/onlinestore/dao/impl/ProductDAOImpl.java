package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.bean.ProductDetails;
import com.hitwh.onlinestore.bean.ProductImage;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;

public class ProductDAOImpl implements ProductDAO {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<ProductDetails> homePageGetProductsByCategoryId(int categoryId) {
        try {
            String sql = "select * from product where cid = ? limit 30";
            return template.query(sql, new BeanPropertyRowMapper<>(ProductDetails.class), categoryId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean addProduct(Product product) {
        System.out.println("ProductDAOImpl--addProduct");
        String sql = "insert into product(name, sub_title, original_price, promote_price, stock, cid, create_date) " +
                "values(?, ?, ?, ?, ?, ?, ?)";
        int count = template.update(sql, product.getName(), product.getSubTitle(), product.getOriginalPrice(),
                product.getPromotePrice(), product.getStock(), product.getCid(), product.getCreateDate());
        return count == 1;
    }

    @Override
    public List<ProductImage> getImagesByProductId(int productId) {
        try {
            String sql = "select id, type from product_image where pid = ?";
            return template.query(sql, new BeanPropertyRowMapper<>(ProductImage.class), productId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from product where id = ?";
        int count = template.update(sql, id);
        return count == 1;
    }

    @Override
    public ProductDetails queryForDetailsById(int id) {
        try {
            String sql = "select id, name, sub_title, original_price, promote_price, stock, cid, " +
                    "create_date from product where id = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(ProductDetails.class), id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ProductDetails> queryByName(String name) {
        String sql = "select * from product where name like ?";
        try {
            return template.query(sql, new BeanPropertyRowMapper<>(ProductDetails.class), "%" + name + "%");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Product queryById(int id) {
        try {
            String sql = "select * from product where id = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ProductImage getImageByProductId(int productId) {
        try {
            String sql = "select * from product_image where pid = ? and type = 'type_single' limit 1";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(ProductImage.class), productId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        System.out.println("ProductDAOImpl--updateProduct");
        String sql = "UPDATE product SET name=?, sub_title=?, original_price=?, promote_price=?, stock=?, cid=?, create_date=? WHERE id=?";
        int count = template.update(sql, product.getName(), product.getSubTitle(), product.getOriginalPrice(),
                product.getPromotePrice(), product.getStock(), product.getCid(), product.getCreateDate(), product.getId());
        return count == 1;
    }


    @Override
    public boolean addImageByProductId(int productId, String type, String url) {
        if (!Objects.equals(type, "type_single") && !Objects.equals(type, "type_detail"))
            return false;
        String sql = "insert into product_image(pid, type, url_path) values(?, ?, ?)";
        int count = template.update(sql, productId, type, url);
        return count == 1;
    }
}
