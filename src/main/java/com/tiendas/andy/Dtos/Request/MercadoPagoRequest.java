package com.tiendas.andy.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MercadoPagoRequest {

    private String notificacion;

    private String email = "allejandro_15@hotmail.com";

    private List<Articulos> articulos;
}