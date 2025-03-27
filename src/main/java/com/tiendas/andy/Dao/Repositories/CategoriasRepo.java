package com.tiendas.andy.Dao.Repositories;

import com.tiendas.andy.Dao.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepo extends JpaRepository<Categoria, Long> {
}