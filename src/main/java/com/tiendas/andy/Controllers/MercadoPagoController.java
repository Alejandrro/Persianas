package com.tiendas.andy.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.tiendas.andy.Dtos.Request.MercadoPagoRequest;
import com.tiendas.andy.Services.ArticulosService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("pagos")
public class MercadoPagoController {

    private final ArticulosService service;

    public MercadoPagoController(ArticulosService service) {
        this.service = service;
    }

    @PostMapping("car")
    public String addProductosPagos(@RequestBody MercadoPagoRequest request) throws MPException, MPApiException {

        System.out.println("Articulos " + request);

        return service.addProducts(request);
    }

    @PostMapping("hook")
    public JsonNode respuestaProductos(@RequestParam Map<String, String> queries, @RequestBody JsonNode body, @RequestHeader Map<String, String> headers) {

        System.out.println("Queries " + queries);
        System.out.println("body " + body);
        System.out.println("headers " + headers);

        return new ObjectMapper().createObjectNode();
    }
}
