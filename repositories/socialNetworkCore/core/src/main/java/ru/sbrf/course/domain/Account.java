package ru.sbrf.course.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Account implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "ACCOUNTID")
    private long accountId;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "USERDATAID")
    public Long userDataId;

    public Account() {
        this.login = "";
        this.password = "";
    }

    public long getAccountId() {
        return accountId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Long getUserDataId() {
        return userDataId;
    }

    public void setUserDataId(Long userDataId) {
        this.userDataId = userDataId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
