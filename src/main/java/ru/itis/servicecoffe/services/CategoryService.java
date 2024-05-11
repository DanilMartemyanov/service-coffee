package ru.itis.servicecoffe.services;

import ru.itis.servicecoffe.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();
}
