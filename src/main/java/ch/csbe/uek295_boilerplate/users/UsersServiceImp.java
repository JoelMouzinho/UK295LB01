package ch.csbe.uek295_boilerplate.users;

import ch.csbe.uek295_boilerplate.users.DTO.UsersCreateDTO;
import ch.csbe.uek295_boilerplate.users.DTO.UsersShowDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersMapper usersMapper;

    @Override
    public UsersShowDetailDTO createUser(UsersCreateDTO userCreateDto) {
        Users user = usersMapper.fromUsersCreateDTO(userCreateDto);
        return usersMapper.toUsersShowDetailDTO(this.usersRepository.save(user));
    }

    @Override
    public List<UsersShowDetailDTO> getAllUsers() {
        List<Users> users = this.usersRepository.findAll();
        List<UsersShowDetailDTO> usersShowDetailDTOS = new ArrayList<>();
        for (Users user : users) {
            usersShowDetailDTOS.add(usersMapper.toUsersShowDetailDTO(user));
        }

        return usersShowDetailDTOS;

    }

    @Override
    public Users getAllUsersById(Long id) {
        return this.usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException("User with the id " + id + " could not be found!"));
    }

    @Override
    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users updateUser(Long id, Users userToUpdate) {
        Users user = this.usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException("User with the id " + id + " could not be found!"));
        user.setUsername(userToUpdate.getUsername());
        user.setPassword(userToUpdate.getPassword());
        return usersRepository.save(user);
    }
}
