package at.fh.ima.swengs.sportmatesdb.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id") // changed from eventTitle to id
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventTitle;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private String eventDescription;
    private String eventTown;
    private int eventZIP;
    private String eventStreet;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date eventDateTime;


    private String eventOrganizer;


    @ManyToMany
    @JoinTable(name="events_eventImage",
            joinColumns = @JoinColumn(name="event_id"),
            inverseJoinColumns = @JoinColumn(name="eventImage_id"))
    private Set<Media> eventImage = new HashSet<>();

    @ManyToOne
    @JsonIgnore
    private Sport sport;

    @ManyToMany
    @JsonIgnore
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
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

    public Set<Media> getEventImage() {
        return eventImage;
    }

    public void setEventImage(Set<Media> eventImage) {
        this.eventImage = eventImage;
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

    public User getEventManager() {
        return eventManager;
    }

    public void setEventManager(User eventManager) {
        this.eventManager = eventManager;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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
