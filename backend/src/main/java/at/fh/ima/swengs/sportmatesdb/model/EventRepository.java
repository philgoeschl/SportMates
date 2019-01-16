package at.fh.ima.swengs.sportmatesdb.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource()
public interface EventRepository extends PagingAndSortingRepository<Event,Long>, JpaRepository<Event, Long>, CrudRepository<Event, Long> {



    //public List<Event> findByEventTitle(@Param("eventTitle") String eventTitle);

    //public List<Event> findAll();


    //public List<Event> findByUsername(@Param("username") String username);

    //public List<Event> findEventByUsersUsername(@Param("username") String username);


}
