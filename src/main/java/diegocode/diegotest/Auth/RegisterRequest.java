package diegocode.diegotest.Auth;

import lombok.Data;
import lombok.Builder;
import diegocode.diegotest.User.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    String username;
    String password;
    String firstName;
    String lastName;
    Role role;
    Integer shopId;
    

}
