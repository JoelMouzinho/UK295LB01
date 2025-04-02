package ch.csbe.uek295_boilerplate.category.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "DTO für die Detail Anzeige von Categories")
public class CategoryShowDetailDTO {
    private String id;
    private String name;
    private String active;
}
