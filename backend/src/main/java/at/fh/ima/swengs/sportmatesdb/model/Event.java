package at.fh.ima.swengs.sportmatesdb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonIgnoreProperties("sports")
    private Sport sport;

    @ManyToMany
    @JsonIgnoreProperties("events")
    private List<User> users;

    private String eventName;
    private String eventType;
    private String eventDescription;
    private String eventTown;
    private int eventZIP;
    private String eventStreet;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private Date eventDateTime;

    private String[] eventParticipants;
    private String eventOrganizer;
    private String eventImage;

    @Version
    @JsonIgnore
    private long version;

    public Event() {
    }

    public Event(String eventName, String eventType, String eventDescription, String eventTown, int eventZIP, String eventStreet, Date eventDateTime, String[] eventParticipants, String eventOrganizer, String eventImage) {
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventTown = eventTown;
        this.eventZIP = eventZIP;
        this.eventStreet = eventStreet;
        this.eventDateTime = eventDateTime;
        this.eventParticipants = eventParticipants;
        this.eventOrganizer = eventOrganizer;
        this.eventImage = eventImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public String[] getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(String[] eventParticipants) {
        this.eventParticipants = eventParticipants;
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

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
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
                ", eventName='" + eventName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventTown='" + eventTown + '\'' +
                ", eventZIP='" + eventZIP + '\'' +
                ", eventStreet='" + eventStreet + '\'' +
                ", eventDateTime=" + eventDateTime +
                ", eventParticipants=" + Arrays.toString(eventParticipants) +
                ", eventOrganizer='" + eventOrganizer + '\'' +
                ", eventImage='" + eventImage + '\'' +
                '}';
    }
}
