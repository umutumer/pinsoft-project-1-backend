package com.firstproject.FirstProject.DTO;

import com.firstproject.FirstProject.Entity.Category;
import lombok.Data;

@Data
public class ProductUpdateDto {
    private Long id;
    private String name;
    private String explanation;
    private Float price;
    private String base64Image;
    private Category category;
    private String token;
}
