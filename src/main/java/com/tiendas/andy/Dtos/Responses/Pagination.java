package com.tiendas.andy.Dtos.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {

    private Integer currentPage;

    private Integer pageSize;

    private Integer totalItems;

    private Integer totalPages;
}