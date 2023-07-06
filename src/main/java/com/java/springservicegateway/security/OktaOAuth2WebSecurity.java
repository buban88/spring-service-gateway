package com.java.springservicegateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
public class OktaOAuth2WebSecurity {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity serverHttpSecurity){
              serverHttpSecurity
                      .authorizeExchange()
                      .anyExchange().authenticated()
                      .and()
                      .oauth2Login()
                      .and()
                      .oauth2ResourceServer()
                      .jwt();

          return serverHttpSecurity.build();
    }
}
