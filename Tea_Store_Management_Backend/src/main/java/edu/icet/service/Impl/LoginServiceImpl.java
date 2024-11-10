package edu.icet.service.Impl;

import edu.icet.entity.LoginEntity;
import edu.icet.repository.loginRepository;
import edu.icet.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final loginRepository repository;

    @Override
    public LoginEntity authenticate(String email, String password, LoginEntity.Role role) {
        return repository.findByEmailAndPasswordAndRole(email, password, role)
                .orElseThrow(() -> new RuntimeException("Invalid email, password, or role"));
    }
}
