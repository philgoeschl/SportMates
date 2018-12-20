package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MovieRepository extends PagingAndSortingRepository<Movie,Long> {

}
