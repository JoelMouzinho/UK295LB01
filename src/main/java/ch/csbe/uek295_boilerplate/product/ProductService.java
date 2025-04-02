package ch.csbe.uek295_boilerplate.product;

import ch.csbe.uek295_boilerplate.product.DTO.ProductCreateDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductShowDetailDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductUpdateDTO;

import java.util.List;

public interface ProductService {
    ProductShowDetailDTO createProduct(ProductCreateDTO productCreateDto);
    List<ProductShowDetailDTO> getAllProducts();
    Product getAllProductsById(Long id);
    void deleteProductById(Long id);
    ProductShowDetailDTO updateProduct(Long id, ProductUpdateDTO product);
}
