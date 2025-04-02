package ch.csbe.uek295_boilerplate.users;

import ch.csbe.uek295_boilerplate.users.DTO.UsersCreateDTO;
import ch.csbe.uek295_boilerplate.users.DTO.UsersShowDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)


public abstract class UsersMapper {
    @Mapping(source = "password", target = "password")
    @Mapping(source = "username", target = "username")
    public abstract Users fromUsersCreateDTO(UsersCreateDTO usersCreateDTO);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "id", target = "userId")
    public abstract UsersShowDetailDTO toUsersShowDetailDTO(Users users);
}
