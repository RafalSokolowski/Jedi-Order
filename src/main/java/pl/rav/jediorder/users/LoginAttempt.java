package pl.rav.jediorder.users;

import lombok.Data;

@Data
public class LoginAttempt {

    private String username;
    private String password;

}
