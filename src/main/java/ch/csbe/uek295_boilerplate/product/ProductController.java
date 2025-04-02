package ch.csbe.uek295_boilerplate.product;

import ch.csbe.uek295_boilerplate.product.DTO.ProductCreateDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductShowDetailDTO;
import ch.csbe.uek295_boilerplate.product.DTO.ProductUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für die Verwaltung von Produkten.
 * Stellt Endpunkte zum Erstellen, Abrufen und Aktualisieren von Produkten bereit.
 */
@RestController
@RequestMapping("products") // Basis-URL für alle Endpunkte in diesem Controller
public class ProductController {

    @Autowired // Automatische Injektion des ProductService
    ProductService productService;

    /**
     * Erstellt ein neues Produkt.
     * @param productCreateDTO Objekt mit den erforderlichen Daten für die Produkterstellung.
     * @return Das erstellte Produkt als ProductShowDetailDTO.
     */
    @PostMapping("")
    public ProductShowDetailDTO createProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        return productService.createProduct(productCreateDTO);
    }

    /**
     * Ruft alle Produkte ab.
     * @return Eine Liste aller Produkte als ProductShowDetailDTO.
     */
    @GetMapping("")
    public List<ProductShowDetailDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Aktualisiert ein bestehendes Produkt.
     * @param id Die ID des zu aktualisierenden Produkts.
     * @param productUpdateDTO Objekt mit den neuen Daten für das Produkt.
     * @return Das aktualisierte Produkt als ProductShowDetailDTO.
     */
    @PutMapping("{id}")
    public ProductShowDetailDTO updateProduct(@PathVariable long id, @RequestBody ProductUpdateDTO productUpdateDTO) {
        return productService.updateProduct(id, productUpdateDTO);
    }
}
