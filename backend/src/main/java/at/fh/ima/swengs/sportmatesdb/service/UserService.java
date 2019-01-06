package at.fh.ima.swengs.sportmatesdb.service;

import at.fh.ima.swengs.sportmatesdb.model.User;
import at.fh.ima.swengs.sportmatesdb.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User entity) {
        return userRepository.save(entity);
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public Set<User> getUsersByUsername(Set<String> dtos) {
        Set<User> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(userRepository.findByUsername(dto).get()));
        }
        return entities;
    }
}
