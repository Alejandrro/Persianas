package com.tiendas.andy.Services.Impl;

import com.tiendas.andy.Dao.Models.Producto;
import com.tiendas.andy.Dao.Repositories.CategoriasRepo;
import com.tiendas.andy.Dao.Repositories.ProductosRepo;
import com.tiendas.andy.Dtos.Request.ProductosRequest;
import com.tiendas.andy.Dtos.Responses.GenericResponse;
import com.tiendas.andy.Dtos.Responses.Pagination;
import com.tiendas.andy.Dtos.Responses.ProductosDto;
import com.tiendas.andy.Services.ProductosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class ProductosServiceImpl implements ProductosService {

    private final ProductosRepo repo;
    private final CategoriasRepo categoriasRepo;

    public ProductosServiceImpl(ProductosRepo repo, CategoriasRepo categoriasRepo) {
        this.repo = repo;
        this.categoriasRepo = categoriasRepo;
    }

    @Override
    public GenericResponse<Producto> save(ProductosRequest request) {

        Producto model = new Producto();

        model.setNombre(request.getName());
        model.setDescripcion(request.getDescripcion());
        model.setPrecio(request.getPrecio());
        model.setSku(request.getSku());
        model.setCategoria(categoriasRepo.getReferenceById(request.getIdCategoria()));
        model.setStock(request.getStock());
        model.setFechaCreacion(Timestamp.from(Instant.now()));
        model.setActivo(true);


        repo.save(model);

        System.out.println("a guardar:: " + model);

        return new GenericResponse<>(model);
    }

    @Override
    public GenericResponse<ProductosDto> getAllProducts(Integer idCategoria, Integer pageNumber) {

        int numeroPagina = pageNumber != null ? (pageNumber - 1) : 0;

        Pageable paginacion = PageRequest.of(numeroPagina, 10);

        Page<Producto> data = repo.findAllByCategoriaId(idCategoria.longValue(), paginacion);

        System.out.println(data.getNumber());

        return new GenericResponse<>(new ProductosDto(data.getContent(),
                new Pagination((numeroPagina + 1), data.getPageable().getPageSize(), (int) data.getTotalElements(), data.getTotalPages())));
    }
}