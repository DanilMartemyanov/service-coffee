package ru.itis.servicecoffe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.servicecoffe.models.Category;

import java.util.Optional;

public interface CategoryRepositories extends JpaRepository<Category, Long> {
        Optional<Category> findById(Long id);
}
