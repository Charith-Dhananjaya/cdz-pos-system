package com.cdz.service.impl;

import com.cdz.configuration.JwtProvider;
import com.cdz.domain.UserRole;
import com.cdz.exceptions.UserException;
import com.cdz.model.User;
import com.cdz.payload.dto.UserDto;
import com.cdz.payload.response.AuthResponse;
import com.cdz.repository.UserRepository;
import com.cdz.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CustomUserImplementation customUserImplementation;

    @Override
    public AuthResponse signup(UserDto userDto) throws UserException {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user != null) {
            throw new UserException("Email is already registered !");
        }
        if(userDto.getRole().equals(UserRole.ROLE_ADMIN)){
            throw new UserException("Role admin is not allowed !");
        }

        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRole(userDto.getRole());


        return null;
    }

    @Override
    public AuthResponse login(UserDto userDto) {
        return null;
    }
}
