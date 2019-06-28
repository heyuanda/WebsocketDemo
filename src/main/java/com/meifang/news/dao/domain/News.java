package com.meifang.news.dao.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "news")
public class News {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 消息正文
     */
    @Column(name = "new_text")
    private String newText;

    /**
     * 接收者
     */
    @Column(name = "accept_user")
    private Integer acceptUser;

    /**
     * 发送者
     */
    @Column(name = "sender")
    private String sender;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewText() {
        return newText;
    }

    public void setNewText(String newText) {
        this.newText = newText;
    }

    public Integer getAcceptUser() {
        return acceptUser;
    }

    public void setAcceptUser(Integer acceptUser) {
        this.acceptUser = acceptUser;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newText='" + newText + '\'' +
                ", acceptUser=" + acceptUser +
                ", sender='" + sender + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
