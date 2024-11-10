package edu.icet.service;

import edu.icet.entity.LoginEntity;

public interface LoginService {
    LoginEntity authenticate(String email, String password, LoginEntity.Role role);
}
