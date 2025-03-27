package com.tiendas.andy.Services;

import com.tiendas.andy.Dao.Models.Producto;
import com.tiendas.andy.Dtos.Request.ProductosRequest;
import com.tiendas.andy.Dtos.Responses.GenericResponse;
import com.tiendas.andy.Dtos.Responses.Productos;
import com.tiendas.andy.Dtos.Responses.ProductosDto;
import org.springframework.data.domain.Page;

public interface ProductosService {

    GenericResponse<Producto> save(ProductosRequest request);

    GenericResponse<ProductosDto> getAllProducts(Integer idCategoria, Integer pageNumber);
}