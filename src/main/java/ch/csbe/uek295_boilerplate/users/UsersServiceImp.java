package ch.csbe.uek295_boilerplate.users;

import ch.csbe.uek295_boilerplate.users.DTO.UsersCreateDTO;
import ch.csbe.uek295_boilerplate.users.DTO.UsersShowDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service-Implementierung für Benutzerverwaltung.
 * Bietet Methoden zur Erstellung, Abfrage, Aktualisierung und Löschung von Benutzerdaten.
 */
@Service
public class UsersServiceImp implements UsersService {

    @Autowired // Automatische Injektion des Benutzer-Repositorys
    UsersRepository usersRepository;

    @Autowired // Automatische Injektion des Mappers für Benutzer-Daten
    UsersMapper usersMapper;

    /**
     * Erstellt einen neuen Benutzer.
     * @param userCreateDto Das DTO mit den Benutzerdaten.
     * @return Die erstellten Benutzerdetails als UsersShowDetailDTO.
     */
    @Override
    public UsersShowDetailDTO createUser(UsersCreateDTO userCreateDto) {
        Users user = usersMapper.fromUsersCreateDTO(userCreateDto);
        return usersMapper.toUsersShowDetailDTO(this.usersRepository.save(user));
    }

    /**
     * Ruft alle Benutzer ab und gibt sie als Liste zurück.
     * @return Eine Liste mit Benutzerdetails als UsersShowDetailDTO.
     */
    @Override
    public List<UsersShowDetailDTO> getAllUsers() {
        List<Users> users = this.usersRepository.findAll();
        List<UsersShowDetailDTO> usersShowDetailDTOS = new ArrayList<>();
        for (Users user : users) {
            usersShowDetailDTOS.add(usersMapper.toUsersShowDetailDTO(user));
        }
        return usersShowDetailDTOS;
    }

    /**
     * Ruft einen Benutzer anhand seiner ID ab.
     * @param id Die ID des Benutzers.
     * @return Das Benutzerobjekt.
     * @throws UsersNotFoundException Falls der Benutzer nicht gefunden wird.
     */
    @Override
    public Users getAllUsersById(Long id) {
        return this.usersRepository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException("User with the id " + id + " could not be found!"));
    }

    /**
     * Löscht einen Benutzer anhand seiner ID.
     * @param id Die ID des zu löschenden Benutzers.
     */
    @Override
    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }

    /**
     * Aktualisiert die Benutzerdaten.
     * @param id Die ID des Benutzers.
     * @param userToUpdate Die neuen Benutzerdaten.
     * @return Der aktualisierte Benutzer.
     * @throws UsersNotFoundException Falls der Benutzer nicht gefunden wird.
     */
    @Override
    public Users updateUser(Long id, Users userToUpdate) {
        Users user = this.usersRepository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException("User with the id " + id + " could not be found!"));

        user.setUsername(userToUpdate.getUsername());
        user.setPassword(userToUpdate.getPassword());

        return usersRepository.save(user);
    }
}