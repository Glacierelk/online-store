package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.Category;
import com.hitwh.onlinestore.bean.Product;

import java.util.List;

public interface CategoryDAO {
    /*
     * 添加商品种类
     * @param category name
     * @return boolean
     */
    boolean addCategory(String name);

    /*
     * 根据种类id返回商品种类
     */
    Category getCategoryById(int id);

    /*
     * 根据商品种类id删除商品种类
     * @param id
     * @return boolean
     */
    boolean deleteCategoryById(int id);

    /*
     * 返回所有商品种类
     * @return List<Category>
     */
    List<Category> listAllCategories();

    /*
     * 删除商品分类
     * @param id
     * @return boolean
     */
    boolean deleteCategory(int id);

    /*
     * 根据分类cid获取商品内容
     * @param cid
     * @return boolean
     */
    List<Product> getPropertyByCid(int cid);
}
