package at.fh.ima.swengs.sportmatesdb.dto;

import at.fh.ima.swengs.sportmatesdb.model.Event;
import at.fh.ima.swengs.sportmatesdb.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

public class SportDTO {

    private String sportName;
    private String sportDescription;
    private boolean team;
    private int teamSize;
    private String sportPicture;


    private Set<String> sportUsers;
    private Set<String> events;

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportDescription() {
        return sportDescription;
    }

    public void setSportDescription(String sportDescription) {
        this.sportDescription = sportDescription;
    }

    public boolean isTeam() {
        return team;
    }

    public void setTeam(boolean team) {
        this.team = team;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String getSportPicture() {
        return sportPicture;
    }

    public void setSportPicture(String sportPicture) {
        this.sportPicture = sportPicture;
    }

    public Set<String> getSportUsers() {
        return sportUsers;
    }

    public void setSportUsers(Set<String> sportUsers) {
        this.sportUsers = sportUsers;
    }

    public Set<String> getEvents() {
        return events;
    }

    public void setEvents(Set<String> events) {
        this.events = events;
    }
}
