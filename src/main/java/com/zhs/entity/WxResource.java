package com.zhs.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_resource")
public class WxResource {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "category_type")
    private Long categoryType;

    @Column(name = "create_time")
    private Date createTime;

    private String description;

    private Integer integral;

    private String name;

    @Column(name = "open_id")
    private String openId;

    private String password;

    @Column(name = "photh_url")
    private String phothUrl;

    private Integer records;

    private Integer status;

    @Column(name = "update_time")
    private Date updateTime;

    private String url;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return category_type
     */
    public Long getCategoryType() {
        return categoryType;
    }

    /**
     * @param categoryType
     */
    public void setCategoryType(Long categoryType) {
        this.categoryType = categoryType;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return integral
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * @param integral
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return open_id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return photh_url
     */
    public String getPhothUrl() {
        return phothUrl;
    }

    /**
     * @param phothUrl
     */
    public void setPhothUrl(String phothUrl) {
        this.phothUrl = phothUrl == null ? null : phothUrl.trim();
    }

    /**
     * @return records
     */
    public Integer getRecords() {
        return records;
    }

    /**
     * @param records
     */
    public void setRecords(Integer records) {
        this.records = records;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}