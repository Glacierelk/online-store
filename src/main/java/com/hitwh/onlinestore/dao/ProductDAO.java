package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.bean.ProductDetails;
import com.hitwh.onlinestore.bean.ProductImage;

import java.util.List;

public interface ProductDAO {
    /*
     * 根据商品类型id获取商品
     * @param categoryId 商品类型id
     * @return 商品列表
     */
    List<ProductDetails> homePageGetProductsByCategoryId(int categoryId);

    /*
     * 新增商品
     */
    boolean addProduct(Product product);

    /*
     * 根据商品id获取商品图片
     * @param productId 商品id
     * @return 图片列表
     */


    ProductImage getOneImageByProductId(int productId);


    List<ProductImage> getImagesByProductId(int productId);

    /*
     * 根据商品id删除商品
     * @param id 商品id
     * @return 是否删除成功
     */
    boolean delete(int id);

    /*
     * 根据商品id获取商品详细信息
     */
    ProductDetails queryForDetailsById(int id);

    /*
     * 根据商品名称获取商品信息，模糊查询
     */
    List<ProductDetails> queryByName(String name);

    /*
     * 根据商品id获取商品信息
     */
    Product queryById(int id);

    /**
     * 根据商品id获取一个商品图片
     */
    ProductImage getImageByProductId(int productId);

    /**
     * 根据商品id修改一个商品
     */
    boolean updateProduct(Product product);

    /**
     * 根据商品id给商品添加图片
     * @param productId 商品id
     * @param type 图片类型
     * @param url 图片url
     */
    boolean addImageByProductId(int productId, String type, String url);
}
