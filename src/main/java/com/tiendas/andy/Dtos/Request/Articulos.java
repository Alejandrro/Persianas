package com.tiendas.andy.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulos {

    private String title;

    private Integer quantity;

    private Integer price;
}