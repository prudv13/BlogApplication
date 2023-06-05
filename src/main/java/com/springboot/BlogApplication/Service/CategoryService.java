package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.CategoryDTO;

public interface CategoryService {
    public CategoryDTO addCategory(CategoryDTO categoryDTO);
    public CategoryDTO getCategory(Long categoryId);
}
