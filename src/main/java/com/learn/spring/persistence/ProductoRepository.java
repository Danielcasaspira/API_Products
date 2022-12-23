package com.learn.spring.persistence;

import com.learn.spring.domain.Product;
import com.learn.spring.domain.repository.ProductRepository;
import com.learn.spring.persistence.crud.ProductoCrudRepository;
import com.learn.spring.persistence.entity.Producto;
import com.learn.spring.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//con esta anotacion indicamos que la clase interactua con la base de datos, tambien podemos usar Component
@Repository
public class ProductoRepository implements ProductRepository {
    //Autowired : Con esta notacion le sedemos el control a Spring para que cree las instancias de estos objetos
    //Estar seguro que el objeto o atributo que se vaya a inyectar SEA un componente de Spring
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    //private List<Producto> getProductList(){
      //  return (List<Producto>) productoCrudRepository.findAll();
    //}

    //public List<Producto> getByCategoria(int idCategoria){
      //  return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    //}

    //public Optional<List<Producto>> getEscasos(int cantidad){
      //  return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    //}

    //public Optional<Producto> getProducto(int idProducto){
      //  return productoCrudRepository.findById(idProducto);
    //}

    //public Producto save(Producto producto){
      //  return productoCrudRepository.save(producto);
    //}

    //public void deleteProducto(int idProducto){
      //   productoCrudRepository.deleteById(idProducto);
    //}

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCayegory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prod -> productMapper.toProducts(prod));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> productMapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}
