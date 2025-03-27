package com.tiendas.andy.Dtos.Responses;

import com.tiendas.andy.Dao.Models.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productos {

    private List<Producto> productos;
}