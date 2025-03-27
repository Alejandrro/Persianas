package com.tiendas.andy.Services;

import com.tiendas.andy.Dao.Models.Categoria;
import com.tiendas.andy.Dtos.Request.CategoriaRequest;
import com.tiendas.andy.Dtos.Responses.Categorias;
import com.tiendas.andy.Dtos.Responses.GenericResponse;

public interface CategoriaService {

    GenericResponse<Categoria> save(CategoriaRequest categoria);

    GenericResponse<Categorias> getCategorias();

}