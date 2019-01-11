package at.fh.ima.swengs.sportmatesdb.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "eventTitle")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventTitle;
    private String eventType;
    private String eventDescription;
    private String eventTown;
    private int eventZIP;
    private String eventStreet;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private Date eventDateTime;


    private String eventOrganizer;
    private String eventImage;

    @ManyToOne
    @JsonIgnoreProperties("sports")
    private Sport sport;

    @ManyToMany
    @JsonIgnoreProperties("events")
    private Set<User> users;

    @ManyToOne
    private User eventManager;






    @Version
    @JsonIgnore
    private long version;

    public Event() {
    }

    public Event(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    /*public Event(Sport sport, Set<User> users, User eventManager, String eventTitle, String eventType, String eventDescription, String eventTown, int eventZIP, String eventStreet, Date eventDateTime, String eventOrganizer, String eventImage) {
        this.sport = sport;
        this.users = users;
        this.eventManager = eventManager;
        this.eventTitle = eventTitle;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventTown = eventTown;
        this.eventZIP = eventZIP;
        this.eventStreet = eventStreet;
        this.eventDateTime = eventDateTime;
        this.eventOrganizer = eventOrganizer;
        this.eventImage = eventImage;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventTown() {
        return eventTown;
    }

    public void setEventTown(String eventTown) {
        this.eventTown = eventTown;
    }

    public int getEventZIP() {
        return eventZIP;
    }

    public void setEventZIP(int eventZIP) {
        this.eventZIP = eventZIP;
    }

    public String getEventStreet() {
        return eventStreet;
    }

    public void setEventStreet(String eventStreet) {
        this.eventStreet = eventStreet;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }


    public String getEventOrganizer() {
        return eventOrganizer;
    }

    public void setEventOrganizer(String eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    public String getEventImage() {
        return eventImage;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public void setEventManager(User eventManager) {
        this.eventManager = eventManager;
    }

    public User getEventManager() {
        return eventManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventTitle='" + eventTitle + '\'' +
                '}';
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                eventZIP == event.eventZIP &&
                version == event.version &&
                Objects.equals(sport, event.sport) &&
                Objects.equals(users, event.users) &&
                Objects.equals(eventTitle, event.eventTitle) &&
                Objects.equals(eventType, event.eventType) &&
                Objects.equals(eventDescription, event.eventDescription) &&
                Objects.equals(eventTown, event.eventTown) &&
                Objects.equals(eventStreet, event.eventStreet) &&
                Objects.equals(eventDateTime, event.eventDateTime) &&
                Objects.equals(eventOrganizer, event.eventOrganizer) &&
                Objects.equals(eventImage, event.eventImage) &&
                Objects.equals(eventManager, event.eventManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sport, users, eventManager, eventTitle, eventType, eventDescription, eventTown, eventZIP, eventStreet, eventDateTime, eventOrganizer, eventImage, version);
    }*/
}
