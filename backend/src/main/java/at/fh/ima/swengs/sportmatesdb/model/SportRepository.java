package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface SportRepository extends PagingAndSortingRepository<Sport,Long> {
    public Optional<Sport> findBySportName(String sportName);

    public List<Sport> findAll();

    public List<Sport> findSportsByUsersUsername(@Param("username") String username);
}
