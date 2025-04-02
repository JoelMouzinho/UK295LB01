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

/**
 * Service-Implementierung für die Verwaltung von Kategorien.
 * Enthält Methoden zur Erstellung, Aktualisierung, Löschung und Abfrage von Kategorien.
 */
@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * Erstellt eine neue Kategorie.
     * @param categoryCreateDto Die Eingabedaten zur Erstellung einer Kategorie.
     * @return Das erstellte Kategorie-Objekt als DTO.
     */
    @Override
    public CategoryShowDetailDTO createCategory(CategoryCreateDTO categoryCreateDto) {
        Category category = categoryMapper.fromCategoryCreateDTO(categoryCreateDto);
        return categoryMapper.toCategoryShowDetailDTO(this.categoryRepository.save(category));
    }

    /**
     * Ruft alle Kategorien aus der Datenbank ab.
     * @return Eine Liste aller Kategorien als DTOs.
     */
    @Override
    public List<CategoryShowDetailDTO> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryShowDetailDTO> categoryShowDetailDTOS = new ArrayList<>();
        for (Category category : categories) {
            categoryShowDetailDTOS.add(categoryMapper.toCategoryShowDetailDTO(category));
        }
        return categoryShowDetailDTOS;
    }

    /**
     * Ruft eine Kategorie anhand ihrer ID ab.
     * @param id Die ID der gesuchten Kategorie.
     * @return Die gefundene Kategorie.
     * @throws CategoryNotFoundException Falls die Kategorie nicht existiert.
     */
    @Override
    public Category getAllCategoriesById(Long id) {
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with the id " + id + " could not be found!"));
    }

    /**
     * Löscht eine Kategorie anhand ihrer ID.
     * @param id Die ID der zu löschenden Kategorie.
     */
    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    /**
     * Aktualisiert eine bestehende Kategorie.
     * @param id Die ID der zu aktualisierenden Kategorie.
     * @param categoryToUpdate Die neuen Werte für die Kategorie.
     * @return Die aktualisierte Kategorie als DTO.
     * @throws CategoryNotFoundException Falls die Kategorie nicht existiert.
     */
    @Override
    public CategoryShowDetailDTO updateCategory(Long id, CategoryUpdateDTO categoryToUpdate) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with the id " + id + " could not be found!"));

        Category categoryData = categoryMapper.fromCategoryUpdateDTO(categoryToUpdate);
        category.setName(categoryData.getName());
        category.setActive(categoryData.getActive());

        return categoryMapper.toCategoryShowDetailDTO(categoryRepository.save(category));
    }
}
