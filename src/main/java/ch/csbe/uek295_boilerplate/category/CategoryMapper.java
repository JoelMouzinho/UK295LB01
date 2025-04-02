package ch.csbe.uek295_boilerplate.category;

import ch.csbe.uek295_boilerplate.category.DTO.CategoryCreateDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryShowDetailDTO;
import ch.csbe.uek295_boilerplate.category.DTO.CategoryUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper-Klasse zur Umwandlung zwischen DTOs und der Category-Entität.
 * Verwendet MapStruct für die automatische Zuordnung von Attributen.
 */
@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    /**
     * Konvertiert ein CategoryCreateDTO in eine Category-Entität.
     * @param categoryCreateDTO Das DTO mit den Erstellungsdaten.
     * @return Die erstellte Category-Entität.
     */
    @Mapping(source = "name", target = "name")
    @Mapping(source = "active", target = "active")
    public abstract Category fromCategoryCreateDTO(CategoryCreateDTO categoryCreateDTO);

    /**
     * Konvertiert eine Category-Entität in ein CategoryShowDetailDTO.
     * @param category Die Category-Entität.
     * @return Das DTO mit den Details der Kategorie.
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    public abstract CategoryShowDetailDTO toCategoryShowDetailDTO(Category category);

    /**
     * Konvertiert ein CategoryUpdateDTO in eine bestehende Category-Entität.
     * @param categoryUpdateDTO Das DTO mit den aktualisierten Daten.
     * @return Die aktualisierte Category-Entität.
     */
    @Mapping(source = "name", target = "name")
    @Mapping(source = "active", target = "active")
    public abstract Category fromCategoryUpdateDTO(CategoryUpdateDTO categoryUpdateDTO);
}
