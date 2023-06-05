package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    public CategoryDTO addCategory(CategoryDTO categoryDTO);
    public CategoryDTO getCategory(Long categoryId);
    public List<CategoryDTO> getAllCategories();
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
    public void deleteCategory(Long categoryId);
}
