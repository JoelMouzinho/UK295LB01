package ch.csbe.uek295_boilerplate.product;

import ch.csbe.uek295_boilerplate.category.Category;
import ch.csbe.uek295_boilerplate.category.CategoryNotFoundException;
import ch.csbe.uek295_boilerplate.product.DTO.ProductCreateDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductShowDetailDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductShowDetailDTO createProduct(ProductCreateDTO productCreateDto) {
        Product product = productMapper.fromProductCreateDTO(productCreateDto);
        return productMapper.toProductShowDetailDTO(this.productRepository.save(product));
    }

    @Override
    public List<ProductShowDetailDTO> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        List<ProductShowDetailDTO> productShowDetailDTOs = new ArrayList<>();
        for (Product product : products) {
            productShowDetailDTOs.add(productMapper.toProductShowDetailDTO(product));
        }

        return productShowDetailDTOs;

    }

    @Override
    public Product getAllProductsById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with the id " + id + " could not be found!"));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductShowDetailDTO updateProduct(Long id, ProductUpdateDTO productToUpdate) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with the id " + id + " could not be found!"));
        Product productData = productMapper.fromProductUpdateDTO(productToUpdate);
        product.setName(productData.getName());
        product.setActive(productData.getActive());
        product.setImage(productData.getImage());
        product.setPrice(productData.getPrice());
        product.setStock(productData.getStock());
        product.setCategory(product.getCategory());
        return productMapper.toProductShowDetailDTO( productRepository.save(product));
    }
}
