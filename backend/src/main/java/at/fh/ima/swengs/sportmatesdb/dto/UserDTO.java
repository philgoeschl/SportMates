package at.fh.ima.swengs.sportmatesdb.dto;

import at.fh.ima.swengs.sportmatesdb.model.Event;
import at.fh.ima.swengs.sportmatesdb.model.Sport;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class UserDTO {

    private Boolean isAdmin;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String eMail;
    private Date dayOfBirth;
    private String homeTown;
    private String userLocation;


    private Set<String> sports;
    private Set<String> events;
    private Set<String> managedEvents;


    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public Set<String> getSports() {
        return sports;
    }

    public void setSports(Set<String> sports) {
        this.sports = sports;
    }

    public Set<String> getEvents() {
        return events;
    }

    public void setEvents(Set<String> events) {
        this.events = events;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Set<String> getManagedEvents() {
        return managedEvents;
    }

    public void setManagedEvents(Set<String> managedEvents) {
        this.managedEvents = managedEvents;
    }
}
