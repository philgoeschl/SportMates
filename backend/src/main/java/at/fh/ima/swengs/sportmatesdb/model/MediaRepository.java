package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface MediaRepository extends PagingAndSortingRepository<Media, Long>, JpaRepository<Media, Long>, CrudRepository<Media, Long> {

}
