package ch.csbe.uek295_boilerplate.product;

import ch.csbe.uek295_boilerplate.product.DTO.ProductCreateDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductShowDetailDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("")
    public ProductShowDetailDTO createProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        ProductShowDetailDTO product = productService.createProduct(productCreateDTO);
        return product;
    }

    @GetMapping("")
    public List<ProductShowDetailDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("{id}")
    public ProductShowDetailDTO updateProduct(@PathVariable long id, @RequestBody ProductUpdateDTO productUpdateDTO) {
        ProductShowDetailDTO product = productService.updateProduct(id, productUpdateDTO);
        return product;
    }
}
