package com.firstproject.FirstProject.Service;

import com.firstproject.FirstProject.DTO.ProductDto;
import com.firstproject.FirstProject.DTO.ProductUpdateDto;
import com.firstproject.FirstProject.Entity.Product;
import com.firstproject.FirstProject.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private JwtService jwtService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public void addProduct( ProductDto productDto) throws IOException {
        if(!jwtService.extractEmail(productDto.getToken()).equals("admin")){
            return;
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setExplanation(productDto.getExplanation());
        product.setBase64Image(productDto.getBase64Image());
        productRepository.save(product);
    }

    public void updateProduct( ProductUpdateDto productForUpdate){
        if(!jwtService.extractEmail(productForUpdate.getToken()).equals("admin")){
            return;
        }
        Product product = productRepository.findById(productForUpdate.getId()).get();
        product.setName(productForUpdate.getName());
        product.setCategory(productForUpdate.getCategory());
        product.setPrice(productForUpdate.getPrice());
        product.setExplanation(productForUpdate.getExplanation());
        product.setBase64Image(productForUpdate.getBase64Image());
        productRepository.save(product);
    }

    public void deleteProduct(Long id, String token){
        if(!jwtService.extractEmail(token).equals("admin")){
            return;
        }
        productRepository.deleteById(id);
    }

}
