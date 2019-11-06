package hw.loan.db;
import hw.loan.model.Bike;
import hw.loan.model.User;
import hw.loan.repository.BikeRepository;
import hw.loan.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private BikeRepository bikeRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder, BikeRepository bikeRepository) {
        this.userRepository = userRepository;
        this.bikeRepository = bikeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all users
        this.userRepository.deleteAll();

        // Delete all bikes
        this.bikeRepository.deleteAll();

        // Crete test users
        User user = new User("user",passwordEncoder.encode("user123"),"","ROLE_USER");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ADMIN");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","MANAGER");

        // Crete test bikes
        Bike a = new Bike("Trek", "red", "brand-new");
        Bike b = new Bike("BMC", "blue", "wrecked");
        Bike c = new Bike("Giant", "green", "brand-new");
        Bike d = new Bike("Csepel", "white", "spared");
        Bike e = new Bike("Focus", "black", "good-condition");
        Bike f = new Bike("Diamondback", "yellow", "good-condition");
        Bike g = new Bike("Kona", "blue", "wrecked");

        List<User> users = Arrays.asList(user,admin,manager);
        List<Bike> bikes = Arrays.asList(a,b,c,d,e,f,g);

        // Save to db
        this.userRepository.saveAll(users);
        this.bikeRepository.saveAll(bikes);
    }
}
