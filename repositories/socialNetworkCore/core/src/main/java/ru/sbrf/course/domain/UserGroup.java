package ru.sbrf.course.domain;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERGROUP")
@Access(AccessType.FIELD)
public class UserGroup implements Serializable{
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    @Column(name = "TITLE")
    private String title;

    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = UserData.class)
    //@JoinTable(name = "USERDATA", joinColumns = { @JoinColumn(name = "GROUPID") }, inverseJoinColumns = { @JoinColumn(name = "ID") })
    @ManyToMany(mappedBy = "groupSet")
    private Set<UserData> userDataSet = new HashSet<>();

    //private List<Long> chats = new ArrayList<>();


/*
    public List<Long> getChats() {
        return chats;
    }

    public void setChats(List<Long> chats) {
        this.chats = chats;
    }
*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<UserData> getUserDataSet() {
        return userDataSet;
    }

    public void setUserDataSet(Set<UserData> userDataSet) {
        this.userDataSet = userDataSet;
    }

}
