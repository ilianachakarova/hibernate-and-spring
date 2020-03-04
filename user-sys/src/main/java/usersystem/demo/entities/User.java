package usersystem.demo.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String username;
    private String password;
    private String email;
    private LocalDateTime registeredOn;
    private LocalDateTime lastTimeLoggedIn;
    private int age;
    private boolean isDeleted;
    private UserTown bornTown;
    private UserTown currentlyLiving;
    private String firstName;
    private String lastName;
    private String fullName;
    private Set<User> friends = new HashSet<>();


    public User() {
    }
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
       if(username.length()<4 || username.length()>30){
           throw new IllegalArgumentException("Username length is invalid");
       }
       this.username = username;

    }
    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String regex = "^.*(?=.{6,50})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        if(password.matches(regex)){
            this.password = password;
        }else {
            throw new IllegalArgumentException("Password does not meet requirements");
        }
    }
    @Column(name = "email",nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String regex = "^[A-z0-9]+[A-z0-9_.]+[A-z0-9]+@[a-z]+[.][a-z]+$";
        if(email.matches(regex)){
        this.email = email;
        }else {
            throw new IllegalArgumentException("Email does not meet the requirements");
        }
    }
    @Column(name = "registered_on")
    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }
    @Column(name = "last_time_logged_in")
    public LocalDateTime getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDateTime lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Column(name = "is_deleted")
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    @ManyToOne
    @JoinColumn(name = "born_town_id")
    public UserTown getBornTown() {
        return bornTown;
    }

    public void setBornTown(UserTown bornTown) {
        this.bornTown = bornTown;
    }
    @ManyToOne
    @JoinColumn(name = "currently_living")
    public UserTown getCurrentlyLiving() {
        return currentlyLiving;
    }

    public void setCurrentlyLiving(UserTown currentlyLiving) {
        this.currentlyLiving = currentlyLiving;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Transient
    public String getFullName() {
        return this.firstName + this.lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
