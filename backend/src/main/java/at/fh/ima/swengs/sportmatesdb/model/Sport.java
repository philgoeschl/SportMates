package at.fh.ima.swengs.sportmatesdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String sportName;
    private String sportDescription;
    private boolean team;
    private int teamSize;
    private String sportPicture;

    @Version
    @JsonIgnore
    private long version;

    public Sport() {
    }

    public Sport(String sportName, String sportDescription, boolean team, int teamSize, String sportPicture) {
        this.sportName = sportName;
        this.sportDescription = sportDescription;
        this.team = team;
        this.teamSize = teamSize;
        this.sportPicture = sportPicture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        Sport sport = (Sport) o;
        return id == sport.id &&
                Objects.equals(sportName, sport.sportName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sportName);
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", sportName='" + sportName + '\'' +
                ", sportDescription='" + sportDescription + '\'' +
                ", team=" + team +
                ", teamSize=" + teamSize +
                ", sportPicture='" + sportPicture + '\'' +
                '}';
    }
}
