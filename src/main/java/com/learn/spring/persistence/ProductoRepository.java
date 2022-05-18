package com.learn.spring.persistence;

import com.learn.spring.persistence.crud.ProductoCrudRepository;
import com.learn.spring.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//con esta anotacion indicamos que la clase interactua con la base de datos, tambien podemos usar Component
@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    private List<Producto> getProductList(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void deleteProducto(int idProducto){
         productoCrudRepository.deleteById(idProducto);
    }

}
