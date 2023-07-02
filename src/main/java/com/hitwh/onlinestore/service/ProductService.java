package com.hitwh.onlinestore.service;

import com.hitwh.onlinestore.bean.Product;

public interface ProductService {
    /*
     * @Description: 添加商品
     */
    boolean addProduct(Product product);

    /*
     * @Description: 删除商品
     * @Param id:产品id
     * @Return: boolean
     */
    boolean delete(int id);

    /*
     * @Description: 获取商品详情
     * @Param id:产品id
     * @Return: 当前商品的所有信息
     */
    Object details(int id);

    /*
     * @Description: 查询商品
     * @Param name: 产品名称
     */
    Object search(String name);

    /*
     * @Description: 修改商品
     * @Param name: 产品名称
     */
    boolean changeProduct(Product product);
}
