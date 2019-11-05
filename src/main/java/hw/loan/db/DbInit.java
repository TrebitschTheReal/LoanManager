package hw.loan.db;
import hw.loan.model.User;
import hw.loan.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User user = new User("user",passwordEncoder.encode("user123"),"","ROLE_USER");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ADMIN");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","MANAGER");

        List<User> users = Arrays.asList(user,admin,manager);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
