package com.backend.FondoRegional.config;

import com.backend.FondoRegional.persistance.entity.fondoregional.Usuario;
import com.backend.FondoRegional.persistance.repository.fondoregional.UsuarioRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final UsuarioRespository repository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            final Usuario usuario= repository.findByCorreo(username).orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));

            return org.springframework.security.core.userdetails.User.builder()
                    .username(usuario.getCorreo())
                    .password(usuario.getContrasena())
                    .authorities(usuario.getRol())
                    .build();
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
