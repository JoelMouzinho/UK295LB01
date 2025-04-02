package ch.csbe.uek295_boilerplate.users.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "DTO fürs anzeigen von Usern")
public class UsersShowDetailDTO {
    private String userId;
    private String username;
}
