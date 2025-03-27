package com.tiendas.andy.Dtos.Responses;

import com.tiendas.andy.Dao.Models.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorias {

    private List<Categoria> categorias;
}