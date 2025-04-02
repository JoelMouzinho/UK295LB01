package ch.csbe.uek295_boilerplate.product.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "DTO für das anzeigen von Produkten")
public class ProductShowDetailDTO {
    private String name;
    private long id;
    private String description;
    private String image;
    private String price;
    private Long category;
    private String stock;
}
