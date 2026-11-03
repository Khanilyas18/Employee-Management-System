package com.employee.dao;

import com.employee.model.User;

public interface UserDAO {

    User login(String username, String password);

}