package ch.csbe.uek295_boilerplate.category;

import ch.csbe.uek295_boilerplate.category.DTO.CategoryCreateDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryShowDetailDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für die Verwaltung von Kategorien.
 * Stellt Endpunkte zum Erstellen, Abrufen und Aktualisieren von Kategorien bereit.
 */
@RestController
@RequestMapping("category") // Basis-URL für alle Endpunkte in diesem Controller
public class CategoryController {

    @Autowired // Automatische Injektion des CategoryService
    CategoryService categoryService;

    /**
     * Erstellt eine neue Kategorie.
     * @param categoryCreateDTO Objekt mit den erforderlichen Daten für die Kategorieerstellung.
     * @return Die erstellte Kategorie als CategoryShowDetailDTO.
     */
    @PostMapping("")
    public CategoryShowDetailDTO createCategory(@RequestBody CategoryCreateDTO categoryCreateDTO) {
        return categoryService.createCategory(categoryCreateDTO);
    }

    /**
     * Ruft alle Kategorien ab.
     * @return Eine Liste aller Kategorien als CategoryShowDetailDTO.
     */
    @GetMapping("")
    public List<CategoryShowDetailDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    /**
     * Aktualisiert eine bestehende Kategorie.
     * @param id Die ID der zu aktualisierenden Kategorie.
     * @param categoryUpdateDTO Objekt mit den neuen Daten für die Kategorie.
     * @return Die aktualisierte Kategorie als CategoryShowDetailDTO.
     */
    @PutMapping("{id}")
    public CategoryShowDetailDTO updateCategory(@PathVariable long id, @RequestBody CategoryUpdateDTO categoryUpdateDTO) {
        return categoryService.updateCategory(id, categoryUpdateDTO);
    }
}
