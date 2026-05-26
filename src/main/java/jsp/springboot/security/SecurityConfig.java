package jsp.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth

                        // READ ACCESS
                        .requestMatchers(HttpMethod.GET, "/book/**")
                        .hasAnyRole("USER", "ADMIN")

                        // CREATE ACCESS
                        .requestMatchers(HttpMethod.POST, "/book/**")
                        .hasRole("ADMIN")

                        // UPDATE ACCESS
                        .requestMatchers(HttpMethod.PUT, "/book/**")
                        .hasRole("ADMIN")

                        // DELETE ACCESS
                        .requestMatchers(HttpMethod.DELETE, "/book/**")
                        .hasRole("ADMIN")

                        .anyRequest()
                        .authenticated()
                )

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}