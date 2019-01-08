package at.fh.ima.swengs.sportmatesdb.service;

import at.fh.ima.swengs.sportmatesdb.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service("userDetailsService")   // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Optional<at.fh.ima.swengs.sportmatesdb.model.User> checkUser = userRepository.findByUsername(username);
            if (checkUser.isPresent()) {
                at.fh.ima.swengs.sportmatesdb.model.User user = checkUser.get();


                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList(user.getAdmin() ? "ROLE_ADMIN" : "ROLE_USER");
                // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
                // And used by auth manager to verify and check user authentication.
                return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }

    @PostConstruct()
    @Transactional
    public void initUsers() {
        if (userRepository.count() == 0) {
            at.fh.ima.swengs.sportmatesdb.model.User admin = new at.fh.ima.swengs.sportmatesdb.model.User();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("12345"));
            admin.setAdmin(true);
            userRepository.save(admin);

            at.fh.ima.swengs.sportmatesdb.model.User tester = new at.fh.ima.swengs.sportmatesdb.model.User();
            tester.setUsername("tester");
            tester.setPassword(encoder.encode("12345"));
            tester.setAdmin(false);
            userRepository.save(tester);
        }
    }

}