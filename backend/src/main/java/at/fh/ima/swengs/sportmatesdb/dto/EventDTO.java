package at.fh.ima.swengs.sportmatesdb.dto;

import at.fh.ima.swengs.sportmatesdb.model.Sport;
import at.fh.ima.swengs.sportmatesdb.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class EventDTO {


    private String eventTitle;
    private String eventType;
    private String eventDescription;
    private String eventTown;
    private String eventManager;
    private int eventZIP;
    private String eventStreet;
    private Date eventDateTime;
    private String eventOrganizer;
    private String eventImage;

    private String sport;
    private Set<String> users;



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

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }


    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public String getEventManager() {
        return eventManager;
    }

    public void setEventManager(String eventManager) {
        this.eventManager = eventManager;
    }
}
