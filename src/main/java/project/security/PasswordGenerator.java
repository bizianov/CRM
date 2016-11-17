package project.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by slava23 on 10/23/2016.
 */
public class PasswordGenerator {
    public static void main(String[] args) {

        String password = "1234567";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        System.out.println(encode);

    }
}
