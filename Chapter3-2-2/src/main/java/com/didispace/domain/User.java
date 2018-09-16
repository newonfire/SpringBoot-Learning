package com.didispace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    public User() {
    }

    public User(String username, String userpwd) {
        this.username = username;
        this.userpwd = userpwd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name="username")
    private String username;

    @Column(name = "userpwd")
    private String userpwd;

    //@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},mappedBy = "user")
    private Set<Weibo> weibos;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }


    public Set<Weibo> getWeibos() {
        return weibos;
    }

    public void setWeibos(Set<Weibo> weibos) {
        this.weibos = weibos;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                '}';
    }
}
