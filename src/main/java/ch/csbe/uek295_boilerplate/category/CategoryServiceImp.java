package ch.csbe.uek295_boilerplate.category;

import ch.csbe.uek295_boilerplate.category.DTO.CategoryCreateDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryShowDetailDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryUpdateDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductShowDetailDTO;
import ch.csbe.uek295_boilerplate.product.Product;
import ch.csbe.uek295_boilerplate.product.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryShowDetailDTO createCategory(CategoryCreateDTO categoryCreateDto) {
        Category category = categoryMapper.fromCategoryCreateDTO(categoryCreateDto);
        return categoryMapper.toCategoryShowDetailDTO(this.categoryRepository.save(category));
    }

    @Override
    public List<CategoryShowDetailDTO> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryShowDetailDTO> categoryShowDetailDTOS = new ArrayList<>();
        for (Category category : categories) {
            categoryShowDetailDTOS.add(categoryMapper.toCategoryShowDetailDTO(category));
        }

        return categoryShowDetailDTOS;

    }

    @Override
    public Category getAllCategoriesById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with the id " + id + " could not be found!"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryShowDetailDTO updateCategory(Long id, CategoryUpdateDTO categoryToUpdate) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with the id " + id + " could not be found!"));
        Category categoryData = categoryMapper.fromCategoryUpdateDTO(categoryToUpdate);
        category.setName(categoryData.getName());
        category.setActive(categoryData.getActive());
        return categoryMapper.toCategoryShowDetailDTO(categoryRepository.save(category)) ;

    }
}
