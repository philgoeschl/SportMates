package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@Transactional(isolation = Isolation.READ_COMMITTED)
public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaRepository<User, Long>, CrudRepository<User, Long> {


    public List<User> findAll();

    public Optional<User> findByUsername(@Param("username") String username);

}
