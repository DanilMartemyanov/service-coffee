package ru.itis.servicecoffe.dto;


import lombok.*;
import ru.itis.servicecoffe.models.Category;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String name;

    public static CategoryDto from(Category category){
        CategoryDto categoryDto = CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
        return categoryDto;
    }

    public static List<CategoryDto> of(List<Category> categories){
        return categories.stream().map(CategoryDto::from).collect(Collectors.toList());
    }
}
