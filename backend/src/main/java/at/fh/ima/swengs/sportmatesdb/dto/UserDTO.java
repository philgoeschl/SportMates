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

    private Long id;
    private boolean isAdmin =false;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String hash;
    private String eMail;
    private Date dayOfBirth;
    private String homeTown;
    private String userLocation;


    private Set<Long> sports;
    private Set<Long> events;
    private Set<Long> managedEvents;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Set<Long> getSports() {
        return sports;
    }

    public void setSports(Set<Long> sports) {
        this.sports = sports;
    }

    public Set<Long> getEvents() {
        return events;
    }

    public void setEvents(Set<Long> events) {
        this.events = events;
    }

    public Set<Long> getManagedEvents() {
        return managedEvents;
    }

    public void setManagedEvents(Set<Long> managedEvents) {
        this.managedEvents = managedEvents;
    }
}
