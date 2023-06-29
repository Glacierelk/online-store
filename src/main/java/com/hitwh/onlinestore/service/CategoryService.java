package com.hitwh.onlinestore.service;

public interface CategoryService {
    /*
     * 获取首页分类
     */
    Object categoryAndProduct();

    /*
     * 后台获取所有分类
     * @return 所有分类, 包括id, name
     */
    Object listAllCategories();
}
