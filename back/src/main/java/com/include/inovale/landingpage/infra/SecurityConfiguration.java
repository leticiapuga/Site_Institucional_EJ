package com.include.inovale.landingpage.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // DESABILITANDO O LOGIN PADRÃO DO SPRING SECURITY
                .csrf(csrf -> csrf.disable())
                // DEFININDO QUE NÃO SERÁ GUARDADO O ESTADO DA SESSÃO (PADRÃO REST)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // ROTAS PUBLICAS
                .authorizeHttpRequests(authorize -> authorize
                        // --- DOCUMENTAÇÃO (SWAGGER) ---
                        .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/index.html/**").permitAll()

                        // --- AUTENTICAÇÃO ---
                        .requestMatchers(HttpMethod.POST, "/auth/entrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/registrar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/auth/validar/*").permitAll()
                        
                        // --- RECUPERAÇÃO DE SENHA ---
                        .requestMatchers(HttpMethod.POST, "/recuperarSenha/gerarCodigo").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/recuperarSenha/atualizar/*").permitAll()

                        // --- QUEM SOMOS (MEMBROS) ---
                        .requestMatchers(HttpMethod.GET, "/membro").permitAll()
                        .requestMatchers(HttpMethod.GET, "/membro/*").permitAll()

                        // --- CONTATO (FALE CONOSCO) ---
                        // Qualquer um pode enviar mensagem (POST)
                        .requestMatchers(HttpMethod.POST, "/contato").permitAll()

                        // --- SERVIÇOS ---
                        // Qualquer um pode ver a lista de serviços (GET)
                        .requestMatchers(HttpMethod.GET, "/servico").permitAll()
                        .requestMatchers(HttpMethod.GET, "/servico/*").permitAll()

                        // --- PARCERIAS (NOVO) ---
                        // Qualquer um pode ver as parcerias (GET)
                        .requestMatchers(HttpMethod.GET, "/parceria").permitAll()
                        .requestMatchers(HttpMethod.GET, "/parceria/*").permitAll()

                        // --- QUALQUER OUTRA ROTA ---
                        // Precisa de login (Token)
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}