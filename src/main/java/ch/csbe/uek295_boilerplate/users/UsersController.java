package ch.csbe.uek295_boilerplate.users;

import ch.csbe.uek295_boilerplate.users.DTO.UsersCreateDTO;
import ch.csbe.uek295_boilerplate.users.DTO.UsersShowDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @PostMapping("")
    public UsersShowDetailDTO createUser(@RequestBody UsersCreateDTO usersCreateDTO) {
        UsersShowDetailDTO users = usersService.createUser(usersCreateDTO);
        return users;
    }

    @GetMapping("")
    public List<UsersShowDetailDTO> getAllUsers() {
        return usersService.getAllUsers();
    }

}
