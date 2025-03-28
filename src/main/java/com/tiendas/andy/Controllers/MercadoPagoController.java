package com.tiendas.andy.Controllers;

import com.tiendas.andy.Dtos.Request.MercadoPagoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagos")
public class MercadoPagoController {

    @PostMapping("car")
    public String addProductosPagos(@RequestBody MercadoPagoRequest request) {

        System.out.println("Articulos " + request);

        return "";
    }
}
