package ru.sbrf.course.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
@Table(name = "USERDATA")
@Access(AccessType.FIELD)
public class UserData implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ACCOUNTID")
    private Long accountId;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "SECONDNAME")
    private String secondName;
    @Column(name = "LASTNAME")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;

    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Group.class)
    //@JoinTable(name = "GROUP", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "GROUPID") })
    @ManyToMany(cascade = {CascadeType.MERGE})
    private Set<UserGroup> groupSet = new HashSet<>();

    public UserData() {
        this.firstName = "";
        this.secondName = "";
        this.lastName = "";
        this.birthday = new Date();
        this.city = "";
        this.country = "";
    }

 //   private List<Chat> friendChats = new ArrayList<>();


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }


   // public List<Chat> getFriendChats() {
     //   return friendChats;}

    // public void setFriendChats(List<Chat> friendChats) {
    //    this.friendChats = friendChats;}

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Set<UserGroup> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<UserGroup> groupSet) {
        this.groupSet = groupSet;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

