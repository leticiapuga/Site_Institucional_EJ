
package com.include.inovale.landingpage.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    // Esse filtro tem a função de definir se o usuário terá acesso ao recurso 
    // solicitado ou não
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                // DESABILITANDO O LOGIN PADRÃO DO SPRING SECURITY
                .csrf(csrf -> csrf.disable())
                // DEFININDO QUE NÃO SERÁ GUARDADO O ESTADO DA SEÇÃO
                // PADRÃO REST
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // ROTAS PUBLICAS
                .authorizeHttpRequests( authorize -> authorize
                    .requestMatchers(
                        HttpMethod.GET,
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui/index.html",
                        "/swagger-ui/index.html/**"
                    ).permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/entrar").permitAll()
                    .requestMatchers(HttpMethod.GET, "/auth/validar/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/registrar").permitAll()
                    .requestMatchers(HttpMethod.POST, "/recuperarSenha/*/gerarLink").permitAll()
                    .requestMatchers(HttpMethod.PATCH, "/recuperarSenha/atualizar/*").permitAll()
                    // QUALQUER ROTA DIFERENTE DAS QUE ESTÃO LISTADAS ACIMA
                    // NECESSITAM DE AUTENTICAÇÃO
                    .anyRequest().authenticated()
                )
                .build();

    }
}
