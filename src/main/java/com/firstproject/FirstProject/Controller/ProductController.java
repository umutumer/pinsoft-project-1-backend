package com.firstproject.FirstProject.Controller;

import com.firstproject.FirstProject.DTO.ProductDto;
import com.firstproject.FirstProject.DTO.ProductUpdateDto;
import com.firstproject.FirstProject.Entity.Product;
import com.firstproject.FirstProject.Service.ProductService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @PermitAll
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    @PermitAll
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.getProductById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody ProductDto productDto) throws IOException {
        productService.addProduct(productDto);
    }

    @PutMapping("/products/update")
    public void  updateProduct(@RequestBody ProductUpdateDto product){
        productService.updateProduct(product);
    }
    @DeleteMapping("/products/delete/{id}/{token}")
    public void  deleteProduct(@PathVariable Long id, @PathVariable String token){
        productService.deleteProduct(id,token);
    }

}
