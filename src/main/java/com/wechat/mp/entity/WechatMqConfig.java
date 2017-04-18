package com.wechat.mp.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by akinoneko on 2017/4/14.
 */
@Entity
public class WechatMqConfig implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 设置微信公众号的appid
     */
    @Column(nullable = false, length = 32)
    private String appId = "wx0a740283272c2347";

    /**
     * 设置微信公众号的app secret
     */
    @Column(nullable = false, length = 64)
    private String secret = "adf2d0d743d6ffb576cc98d57dd799e9";

    /**
     * 设置微信公众号的token
     */
    @Column(nullable = false)
    private String token = "123123123";

    /**
     * 设置微信公众号的EncodingAESKey
     */
    private String aesKey = "123";

    @Column(nullable = false)
    private Date updateTime;

    @Column(nullable = false)
    private Date createTime;

    /**
     * 公众号对应的用户
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
