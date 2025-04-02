package ch.csbe.uek295_boilerplate.product;

import ch.csbe.uek295_boilerplate.category.Category;
import ch.csbe.uek295_boilerplate.category.CategoryRepository;
import ch.csbe.uek295_boilerplate.category.CategoryServiceImp;
import ch.csbe.uek295_boilerplate.product.DTO.ProductCreateDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductShowDetailDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Mapper-Klasse zur Umwandlung zwischen DTOs und der Produkt-Entität.
 * Verwendet MapStruct für die automatische Zuordnung von Attributen.
 */
@Mapper(
        componentModel = "spring",
        uses = {
                CategoryServiceImp.class,
        }
)
public abstract class ProductMapper {

    /**
     * Konvertiert ein ProductCreateDTO in eine Product-Entität.
     * @param productCreateDTO Das DTO mit den Erstellungsdaten.
     * @return Die erstellte Product-Entität.
     */
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "imageUrl", target = "image")
    @Mapping(source = "category", target = "category")
    public abstract Product fromProductCreateDTO(ProductCreateDTO productCreateDTO);

    /**
     * Konvertiert eine Product-Entität in ein ProductShowDetailDTO.
     * @param product Die Product-Entität.
     * @return Das DTO mit den Details des Produkts.
     */
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "category.id", target = "category")
    public abstract ProductShowDetailDTO toProductShowDetailDTO(Product product);

    /**
     * Konvertiert ein ProductUpdateDTO in eine bestehende Product-Entität.
     * @param productUpdateDTO Das DTO mit den aktualisierten Daten.
     * @return Die aktualisierte Product-Entität.
     */
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "imageUrl", target = "image")
    @Mapping(source = "category", target = "category")
    public abstract Product fromProductUpdateDTO(ProductUpdateDTO productUpdateDTO);
}
