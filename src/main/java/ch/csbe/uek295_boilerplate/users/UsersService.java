package ch.csbe.uek295_boilerplate.users;

import ch.csbe.uek295_boilerplate.users.DTO.UsersCreateDTO;
import ch.csbe.uek295_boilerplate.users.DTO.UsersShowDetailDTO;

import java.util.List;

public interface UsersService {
    UsersShowDetailDTO createUser(UsersCreateDTO userCreateDto);
    List<UsersShowDetailDTO> getAllUsers();
    Users getAllUsersById(Long id);
    void deleteUserById(Long id);
    Users updateUser(Long id, Users user);
}
