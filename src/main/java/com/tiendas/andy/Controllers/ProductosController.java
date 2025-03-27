package com.tiendas.andy.Controllers;

import com.tiendas.andy.Dao.Models.Producto;
import com.tiendas.andy.Dtos.Request.ProductosRequest;
import com.tiendas.andy.Dtos.Responses.GenericResponse;
import com.tiendas.andy.Dtos.Responses.Productos;
import com.tiendas.andy.Dtos.Responses.ProductosDto;
import com.tiendas.andy.Services.ProductosService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("productos")
public class ProductosController {
    private final ProductosService service;

    public ProductosController(ProductosService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GenericResponse<Producto> save(@RequestBody ProductosRequest request) {

        System.out.println("Peticon:: " + request);
        return service.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<ProductosDto> getProductos(@RequestParam(name = "idCategoria") Integer idCategoria,
                                                      @RequestParam(name = "pageNumber", required = false) Integer pageNumber) {
        System.out.println("Nueva solicitud");
        return service.getAllProducts(idCategoria, pageNumber);
    }
}