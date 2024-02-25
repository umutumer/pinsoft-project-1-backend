package com.firstproject.FirstProject.Service;

import com.firstproject.FirstProject.DTO.AuthenticationRequest;
import com.firstproject.FirstProject.DTO.AuthenticationResponse;
import com.firstproject.FirstProject.DTO.RegisterRequest;
import com.firstproject.FirstProject.Entity.Role;
import com.firstproject.FirstProject.Entity.User;
import com.firstproject.FirstProject.Repository.RoleRepository;
import com.firstproject.FirstProject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        Role role = roleRepository.findByName("user").get(0);
        user.setRole(role);
        User savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(savedUser);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user =userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();
    }
}
