package com.firstproject.FirstProject.Service;

import com.firstproject.FirstProject.Entity.Product;
import com.firstproject.FirstProject.Repository.ProductRepository;
import com.firstproject.FirstProject.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public void addProduct( ProductDto productDto) throws IOException {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setExplanation(productDto.getExplanation());
        product.setBase64Image(productDto.getBase64Image());
        productRepository.save(product);
    }
}
