package com.tiendas.andy.Dao.Repositories;

import com.tiendas.andy.Dao.Models.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepo extends JpaRepository<Producto, Long> {

    Page<Producto> findAllByCategoriaId(Long idCategoria, Pageable pageable);
}