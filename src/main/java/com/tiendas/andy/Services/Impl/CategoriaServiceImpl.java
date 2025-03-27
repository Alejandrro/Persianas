package com.tiendas.andy.Services.Impl;

import com.tiendas.andy.Dao.Models.Categoria;
import com.tiendas.andy.Dao.Repositories.CategoriasRepo;
import com.tiendas.andy.Dtos.Request.CategoriaRequest;
import com.tiendas.andy.Dtos.Responses.Categorias;
import com.tiendas.andy.Dtos.Responses.GenericResponse;
import com.tiendas.andy.Services.CategoriaService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriasRepo repo;

    public CategoriaServiceImpl(CategoriasRepo repo) {
        this.repo = repo;
    }

    @Override
    public GenericResponse<Categoria> save(CategoriaRequest categoria) {

        Categoria model = new Categoria();

        model.setNombre(categoria.getName());
        model.setDescripcion(categoria.getDescripcion());

        repo.save(model);

        GenericResponse<Categoria> response = new GenericResponse<>();

        response.setResultado(model);

        return response;
    }

    @Override
    public GenericResponse<Categorias> getCategorias() {
        return new GenericResponse<>(new Categorias(repo.findAll()));
    }
}