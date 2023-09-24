package diegocode.diegotest.User;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

   

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    

    // Método para crear un nuevo usuario
    public User createUser(User newUser) {
        // Hashea la contraseña antes de guardarla en la base de datos
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    // Método para actualizar un usuario existente
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //eliminar un usuario por id
    public void deleteUser(User existingUser) {
        userRepository.delete(existingUser);
    }

    public User findUserById(Integer id) {
        return null;
    }

    

    // Puedes agregar más métodos según tus necesidades, como eliminar usuarios, listar todos los usuarios, etc.
}
