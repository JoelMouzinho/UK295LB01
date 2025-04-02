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

@Mapper (
        componentModel = "spring",
        uses = {
                CategoryServiceImp.class,
        }
)
public abstract class ProductMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "imageUrl", target = "image")
    @Mapping(source = "category", target = "category")
    public abstract Product fromProductCreateDTO(ProductCreateDTO productCreateDTO);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "category.id", target = "category")
    public abstract ProductShowDetailDTO toProductShowDetailDTO(Product product);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "imageUrl", target = "image")
    @Mapping(source = "category", target = "category")
    public abstract Product fromProductUpdateDTO(ProductUpdateDTO productUpdateDTO);

}
