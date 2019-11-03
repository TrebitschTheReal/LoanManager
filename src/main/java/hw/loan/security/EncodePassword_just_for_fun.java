package hw.loan.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword_just_for_fun {
    public static void main(String[] args){
        String password = "b";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);


    }
}
