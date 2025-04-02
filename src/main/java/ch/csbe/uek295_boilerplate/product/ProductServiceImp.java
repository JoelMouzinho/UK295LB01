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

/**
 * Service-Implementierung für die Verwaltung von Produkten.
 * Diese Klasse enthält die Geschäftslogik für das Erstellen, Abrufen, Aktualisieren und Löschen von Produkten.
 */
@Service
public class ProductServiceImp implements ProductService {

    @Autowired // Automatische Injektion des ProductRepository
    ProductRepository productRepository;

    @Autowired // Automatische Injektion des ProductMapper für die Umwandlung von DTOs und Entitäten
    ProductMapper productMapper;

    /**
     * Erstellt ein neues Produkt und speichert es in der Datenbank.
     * @param productCreateDto Das DTO mit den Erstellungsdaten.
     * @return Das erstellte Produkt als ProductShowDetailDTO.
     */
    @Override
    public ProductShowDetailDTO createProduct(ProductCreateDTO productCreateDto) {
        Product product = productMapper.fromProductCreateDTO(productCreateDto);
        return productMapper.toProductShowDetailDTO(this.productRepository.save(product));
    }

    /**
     * Ruft alle vorhandenen Produkte ab.
     * @return Eine Liste aller Produkte als ProductShowDetailDTO.
     */
    @Override
    public List<ProductShowDetailDTO> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        List<ProductShowDetailDTO> productShowDetailDTOs = new ArrayList<>();
        for (Product product : products) {
            productShowDetailDTOs.add(productMapper.toProductShowDetailDTO(product));
        }
        return productShowDetailDTOs;
    }

    /**
     * Ruft ein Produkt anhand seiner ID ab.
     * @param id Die ID des Produkts.
     * @return Das gefundene Produkt.
     * @throws ProductNotFoundException Falls kein Produkt mit der gegebenen ID existiert.
     */
    @Override
    public Product getAllProductsById(Long id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with the id " + id + " could not be found!"));
    }

    /**
     * Löscht ein Produkt anhand seiner ID.
     * @param id Die ID des zu löschenden Produkts.
     */
    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Aktualisiert ein bestehendes Produkt.
     * @param id Die ID des zu aktualisierenden Produkts.
     * @param productToUpdate Das DTO mit den neuen Produktinformationen.
     * @return Das aktualisierte Produkt als ProductShowDetailDTO.
     * @throws ProductNotFoundException Falls das Produkt nicht gefunden wird.
     */
    @Override
    public ProductShowDetailDTO updateProduct(Long id, ProductUpdateDTO productToUpdate) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with the id " + id + " could not be found!"));

        Product productData = productMapper.fromProductUpdateDTO(productToUpdate);
        product.setName(productData.getName());
        product.setActive(productData.getActive());
        product.setImage(productData.getImage());
        product.setPrice(productData.getPrice());
        product.setStock(productData.getStock());
        product.setCategory(product.getCategory());

        return productMapper.toProductShowDetailDTO(productRepository.save(product));
    }
}
