package ch.csbe.uek295_boilerplate.users;

import ch.csbe.uek295_boilerplate.users.DTO.UsersCreateDTO;
import ch.csbe.uek295_boilerplate.users.DTO.UsersShowDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für Benutzerverwaltung.
 * Ermöglicht das Erstellen und Abrufen von Benutzerdaten.
 */
@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired // Automatische Injektion des UsersService
    UsersService usersService;

    /**
     * Erstellt einen neuen Benutzer.
     * @param usersCreateDTO Das DTO mit den Benutzerdaten.
     * @return Die erstellten Benutzerdetails als UsersShowDetailDTO.
     */
    @PostMapping("")
    public UsersShowDetailDTO createUser(@RequestBody UsersCreateDTO usersCreateDTO) {
        return usersService.createUser(usersCreateDTO);
    }

    /**
     * Ruft eine Liste aller Benutzer ab.
     * @return Eine Liste mit Benutzerdetails als UsersShowDetailDTO.
     */
    @GetMapping("")
    public List<UsersShowDetailDTO> getAllUsers() {
        return usersService.getAllUsers();
    }
}
