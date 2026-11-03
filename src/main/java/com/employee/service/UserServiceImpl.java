
package com.employee.service;

import com.employee.dao.UserDAO;
import com.employee.dao.UserDAOImpl;
import com.employee.model.User;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public User login(String username, String password) {

        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            return null;
        }

        return userDAO.login(username, password);
    }
}
