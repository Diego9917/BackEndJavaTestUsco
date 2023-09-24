package diegocode.diegotest.User;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

   
   
    //buscar usuairo por username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        UserService userService = new UserService(userRepository, null);
        // Busca el usuario existente por su username
        User existingUser = userService.findUserByUsername(username);
        
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(existingUser);
    }
 
    

    //actualizar usuario por id
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        UserService userService = new UserService(userRepository, null);
        // Busca el usuario existente por su ID
        User existingUser = userService.findUserById(id);
        
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Realiza las actualizaciones necesarias en el usuario existente
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        
        // Guarda los cambios en la base de datos
        userService.saveUser(existingUser);
        
        return ResponseEntity.ok("Usuario actualizado con éxito");
    }

    //ELIminar un usuario segun si id
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        UserService userService = new UserService(userRepository, null);
        // Busca el usuario existente por su ID
        User existingUser = userService.findUserById(id);
        
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Elimina el usuario de la base de datos
        userService.deleteUser(existingUser);
        
        return ResponseEntity.ok("Usuario eliminado con éxito");
    }
}
