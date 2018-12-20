package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface EventRepository extends PagingAndSortingRepository<Event,Long> {

    //This would be exposed under the URL: http://localhost:8080/actors/search/findByEventTitle
    public List<Event> findByEventTitle(@Param("eventTitle") String eventTitle);

}
