package ch.csbe.uek295_boilerplate.category;

import ch.csbe.uek295_boilerplate.category.DTO.CategoryCreateDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryShowDetailDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    public CategoryShowDetailDTO createCategory(@RequestBody CategoryCreateDTO categoryCreateDTO) {
        CategoryShowDetailDTO category = categoryService.createCategory(categoryCreateDTO);
        return category;
    }

    @GetMapping("")
    public List<CategoryShowDetailDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PutMapping("{id}")
    public CategoryShowDetailDTO updateCategory(@PathVariable long id, @RequestBody CategoryUpdateDTO categoryUpdateDTO) {
        CategoryShowDetailDTO category = categoryService.updateCategory(id, categoryUpdateDTO);
        return category;
    }
}
