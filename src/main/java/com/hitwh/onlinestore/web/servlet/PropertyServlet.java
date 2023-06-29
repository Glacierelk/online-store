package com.hitwh.onlinestore.web.servlet;

import com.hitwh.onlinestore.service.PropertyService;
import com.hitwh.onlinestore.service.impl.PropertyServiceImpl;

import javax.servlet.annotation.WebServlet;

@WebServlet("/property/*")
public class PropertyServlet extends BaseServlet {
    private final PropertyService propertyService = new PropertyServiceImpl();

}
