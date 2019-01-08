package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
<<<<<<< Updated upstream
public interface UserRepository extends PagingAndSortingRepository<User,String> {


    public List<User> findAll();

    public Optional<User> findByUsername (String userName);
=======
public interface UserRepository extends PagingAndSortingRepository<Sport,Long> {
    User findByUsername(String username);
>>>>>>> Stashed changes
}
