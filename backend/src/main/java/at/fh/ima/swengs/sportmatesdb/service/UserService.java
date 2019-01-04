package at.fh.ima.swengs.sportmatesdb.service;

import at.fh.ima.swengs.sportmatesdb.model.User;
import at.fh.ima.swengs.sportmatesdb.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User entity) {
        return userRepository.save(entity);
    }



    public List<User> getAll() {
        return userRepository.findAll();
    }
}
