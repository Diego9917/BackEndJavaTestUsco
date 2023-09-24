package diegocode.diegotest.User;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByUsername(String username); //este metodo es para buscar por username

}