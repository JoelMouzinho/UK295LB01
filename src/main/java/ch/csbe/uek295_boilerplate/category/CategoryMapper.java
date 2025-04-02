package ch.csbe.uek295_boilerplate.category;

import ch.csbe.uek295_boilerplate.category.DTO.CategoryCreateDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryShowDetailDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public abstract class CategoryMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "active", target = "active")
    public abstract Category fromCategoryCreateDTO(CategoryCreateDTO categoryCreateDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    public abstract CategoryShowDetailDTO toCategoryShowDetailDTO(Category category);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "active", target = "active")
    public abstract Category fromCategoryUpdateDTO(CategoryUpdateDTO categoryUpdateDTO);
}
