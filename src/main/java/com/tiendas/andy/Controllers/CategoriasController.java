package com.tiendas.andy.Controllers;

import com.tiendas.andy.Dao.Models.Categoria;
import com.tiendas.andy.Dtos.Request.CategoriaRequest;
import com.tiendas.andy.Dtos.Responses.Categorias;
import com.tiendas.andy.Dtos.Responses.GenericResponse;
import com.tiendas.andy.Services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("categorias")
public class CategoriasController {

    private final CategoriaService service;

    public CategoriasController(CategoriaService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GenericResponse<Categoria> saveCategoria(@RequestBody CategoriaRequest body) {

        return service.save(body);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public GenericResponse<Categorias> getCategorias() {

        return service.getCategorias();
    }
}