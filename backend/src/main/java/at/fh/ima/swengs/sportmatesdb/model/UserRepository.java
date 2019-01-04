package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User,Long> {


    public List<User> findAll();

    User findByUsername(String username);
}
