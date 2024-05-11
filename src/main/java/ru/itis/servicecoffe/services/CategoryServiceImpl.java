package ru.itis.servicecoffe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.servicecoffe.dto.CategoryDto;
import ru.itis.servicecoffe.models.Category;
import ru.itis.servicecoffe.repositories.CategoryRepositories;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepositories categoryRepositories;

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepositories.findAll();
        return CategoryDto.of(categories);
    }
}
