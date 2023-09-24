package diegocode.diegotest.Auth;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import diegocode.diegotest.Jwt.JwtService;
import diegocode.diegotest.Shop.Shop;
import diegocode.diegotest.Shop.ShopRepository;
import diegocode.diegotest.User.User;
import diegocode.diegotest.User.UserRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final ShopRepository shopRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    // se creaun una instancia del authentication manager porque se necesita que el usuario se autentique
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {

        Shop shop = shopRepository.findById(request.getShopId())
        .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));


        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .role(request.getRole())
            .shop(shop)
            .build();

        userRepository.save(user);

        return AuthResponse.builder() 
            .token(jwtService.getToken(user))
            .build();
    }

   

    }
