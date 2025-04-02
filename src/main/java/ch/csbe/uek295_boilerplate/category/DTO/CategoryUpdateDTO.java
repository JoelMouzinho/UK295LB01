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

@Schema(description = "DTO für das Updaten einer Category")
public class CategoryUpdateDTO {
    private String name;
    private String active;
}
