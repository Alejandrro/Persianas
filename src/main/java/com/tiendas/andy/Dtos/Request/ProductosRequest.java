package com.tiendas.andy.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosRequest {

    private String name;

    private String descripcion;

    private Double precio;

    private String sku;

    private Long idCategoria;

    private Long stock;

    private Timestamp fechaActualizacion;

    private Boolean activo;
}