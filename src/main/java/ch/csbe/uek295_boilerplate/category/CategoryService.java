package ch.csbe.uek295_boilerplate.category;

import ch.csbe.uek295_boilerplate.category.DTO.CategoryCreateDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryShowDetailDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryUpdateDTO;

import java.util.List;

public interface CategoryService {
    CategoryShowDetailDTO createCategory(CategoryCreateDTO categoryCreateDto);
    List<CategoryShowDetailDTO> getAllCategories();
    Category getAllCategoriesById(Long id);
    void deleteCategoryById(Long id);
    CategoryShowDetailDTO updateCategory(Long id, CategoryUpdateDTO categoryToUpdate);
}
