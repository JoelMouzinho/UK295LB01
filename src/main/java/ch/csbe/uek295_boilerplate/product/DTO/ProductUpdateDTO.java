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

@Schema(description = "DTO für das Updaten eines Produkts")
public class ProductUpdateDTO {
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Long category;
}
