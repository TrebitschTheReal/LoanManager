package hw.loan.security;

import hw.loan.model.User;
import hw.loan.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(s);

        if (user == null) { throw new UsernameNotFoundException("No user found for " + user.getUsername() + "."); }

        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}