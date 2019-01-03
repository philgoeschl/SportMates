package at.fh.ima.swengs.sportmatesdb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    /*@ManyToMany(mappedBy = "users")
    private List<Sport> sports;

    @ManyToMany(mappedBy = "users")
    private List<Event> events;*/


    @Version
    private long version;


    private Boolean isAdmin;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private Date dayOfBirth;

    private String homeTown;
    private String userLocation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                version == user.version &&
                Objects.equals(isAdmin, user.isAdmin) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(dayOfBirth, user.dayOfBirth) &&
                Objects.equals(homeTown, user.homeTown) &&
                Objects.equals(userLocation, user.userLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, isAdmin, firstName, lastName, username, password, dayOfBirth, homeTown, userLocation);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", version=" + version +
                ", isAdmin=" + isAdmin +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", homeTown='" + homeTown + '\'' +
                ", userLocation='" + userLocation + '\'' +
                '}';
    }


    public User() {
    }

    public User(Boolean isAdmin, String firstName, String lastName, String username, String password, Date dayOfBirth, String homeTown, String userLocation) {
        this.isAdmin = isAdmin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.homeTown = homeTown;
        this.userLocation = userLocation;
    }


    public User(Boolean isAdmin, String firstName, String lastName, String username) {
        this.isAdmin = isAdmin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }
}
