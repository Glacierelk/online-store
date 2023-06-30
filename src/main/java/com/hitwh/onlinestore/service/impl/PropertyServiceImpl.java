package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.dao.PropertyDAO;
import com.hitwh.onlinestore.dao.impl.PropertyDAOImpl;
import com.hitwh.onlinestore.service.PropertyService;

public class PropertyServiceImpl implements PropertyService {
    private final PropertyDAO propertyDAO = new PropertyDAOImpl();
    @Override
    public boolean addProperty(int cid, String name) {
        return propertyDAO.addProperty(cid, name);
    }
}
