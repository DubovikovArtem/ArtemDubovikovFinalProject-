package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Auth {
    //{
    //  "username": "artem1",
    //  "password": "987654321",
    //  "confirmPassword": "987654321"
    //}
    private String username;
    private String password;
    private String confirmPassword;
}
