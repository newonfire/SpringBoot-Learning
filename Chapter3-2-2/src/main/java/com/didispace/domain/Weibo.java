package com.didispace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="weibo")
public class Weibo {

    public Weibo() {
    }

    public Weibo(User user, String weiboText, Date createDate) {
        this.user = user;
        this.weiboText = weiboText;
        this.createDate = createDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long weiboId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "weibo_text")
    private String weiboText;

    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},mappedBy = "weibo")
    private Set<Comment> comments;


    public long getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(long weiboId) {
        this.weiboId = weiboId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getWeiboText() {
        return weiboText;
    }

    public void setWeiboText(String weiboText) {
        this.weiboText = weiboText;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Weibo{" +
                "weiboId=" + weiboId +
                ", user=" + user +
                ", weiboText='" + weiboText + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
