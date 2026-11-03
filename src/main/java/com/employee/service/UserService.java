package com.employee.service;

import com.employee.model.User;

public interface UserService {

    User login(String username, String password);

}