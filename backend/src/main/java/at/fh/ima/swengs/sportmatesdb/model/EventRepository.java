package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface EventRepository extends PagingAndSortingRepository<Event,String> {


    public List<Event> findByEventTitle(@Param("eventTitle") String eventTitle);

    public List<Event> findAll();

    public List<Event> findEventByUsersUsername(@Param("username") String username);

}
