package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource

public interface UserRepository extends PagingAndSortingRepository<User, String>, JpaRepository<User, String>, CrudRepository<User, String> {


    public List<User> findAll();

    public Optional<User> findByUsername(@Param("username") String username);

}
