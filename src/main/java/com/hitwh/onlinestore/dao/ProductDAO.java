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
    List<ProductImage> getImagesByProductId(int productId);

    /*
     * 根据商品id删除商品
     * @param id 商品id
     * @return 是否删除成功
     */
    boolean delete(int id);

    /*
     * 根据商品id获取商品信息
     */
    ProductDetails queryById(int id);
}
