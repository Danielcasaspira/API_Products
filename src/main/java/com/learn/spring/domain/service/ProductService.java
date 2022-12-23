package com.learn.spring.domain.service;

import com.learn.spring.domain.Product;
import com.learn.spring.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCayegory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(prod -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
        //Manera mas optimizada sin validar si existe algun producto
        /*try{
            productRepository.delete(productId);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }*/
        //Otra manera de hacer esta logica mas imperativa
        /*if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        }*/
    }

    public boolean updateProduct(int productId, Product product){
        return getProduct(productId).map(prod -> {
            prod.setName(product.getName());
            prod.setCategoryId(product.getCategoryId());
            prod.setPrice(product.getPrice());
            prod.setStock(product.getStock());
            prod.setActive(prod.isActive());
            productRepository.save(prod);
            return true;
        }).orElse( false);

    }



}
