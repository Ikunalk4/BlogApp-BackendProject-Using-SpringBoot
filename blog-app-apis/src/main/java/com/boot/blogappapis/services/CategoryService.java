package com.boot.blogappapis.services;

import java.util.List;

import com.boot.blogappapis.payloads.CategoryDto;

public interface CategoryService {
	
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	void deleteCategory(Integer categoryId);

	CategoryDto getCategory(Integer categoryId);
	
	List<CategoryDto> getAllCategory();

}
