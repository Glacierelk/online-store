package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.User;
import com.hitwh.onlinestore.dao.UserDAO;
import com.hitwh.onlinestore.dao.impl.UserDAOImpl;
import com.hitwh.onlinestore.service.UserService;
import org.junit.Test;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserDAO userDAO = new UserDAOImpl();
    @Override
    public User login(String username, String password) {
        return userDAO.getUserByNameAndPassword(username, password);
    }



    @Override
    public boolean register(User user) {
        if(userDAO.getUserByName(user.getName())!=null){
            return false;
        }else {
            userDAO.addUser(user);
            return true;
        }
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    @Override
    public boolean deleteUser(String name) {
        return userDAO.deleteUserByName(name);
    }

    @Test
    public void test1(){
        String name = "test001";
        this.deleteUser(name);
    }


}
