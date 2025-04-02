package ch.csbe.uek295_boilerplate.users;

import ch.csbe.uek295_boilerplate.users.DTO.UsersCreateDTO;
import ch.csbe.uek295_boilerplate.users.DTO.UsersShowDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper für die Umwandlung zwischen Benutzer-Entitäten und DTOs.
 * Wird von MapStruct genutzt, um Daten automatisch zu konvertieren.
 */
@Mapper(
        componentModel = "spring"
)
public abstract class UsersMapper {

    /**
     * Wandelt ein UsersCreateDTO in eine Users-Entität um.
     * @param usersCreateDTO Das DTO mit den Benutzerdaten.
     * @return Die erstellte Users-Entität.
     */
    @Mapping(source = "password", target = "password")
    @Mapping(source = "username", target = "username")
    public abstract Users fromUsersCreateDTO(UsersCreateDTO usersCreateDTO);

    /**
     * Wandelt eine Users-Entität in ein UsersShowDetailDTO um.
     * @param users Die Benutzer-Entität.
     * @return Das UsersShowDetailDTO mit den relevanten Benutzerdetails.
     */
    @Mapping(source = "username", target = "username")
    @Mapping(source = "id", target = "userId")
    public abstract UsersShowDetailDTO toUsersShowDetailDTO(Users users);
}
