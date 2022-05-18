package com.learn.spring.persistence.crud;

import com.learn.spring.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //Primer forma de hacer un query de forma nativa
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ? ORDER BY nombre ASC", nativeQuery = true)
    //Segunda forma de hacer query mediante el nombre del nombre con QueryMethods
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);


    //Primer forma de hacer un query de forma nativa
    @Query(value = "SELECT * FROM productos WHERE cantidad_stock >= ? AND estado = ?", nativeQuery = true)
    //Segunda forma de hacer query mediante el nombre del nombre con QueryMethods
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);



}
