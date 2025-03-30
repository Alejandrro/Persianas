package com.tiendas.andy.Beans;

import com.mercadopago.MercadoPagoConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MercadoConfig {

    @Value("${mercadopago.comprador.token}")
    private String token;

    @PostConstruct
    public void init() {
        System.out.println("agregando el token de mercado:::" + token);
        MercadoPagoConfig.setAccessToken(token);
    }

    public String toke() {
        return token;
    }
}