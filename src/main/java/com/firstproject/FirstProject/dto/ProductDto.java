package com.firstproject.FirstProject.dto;

import com.firstproject.FirstProject.Entity.Category;
import lombok.Data;
@Data
public class ProductDto {
    private String name;
    private String explanation;
    private Float price;
    private String base64Image;
    private Category category;
}
