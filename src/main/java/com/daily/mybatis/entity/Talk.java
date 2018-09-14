package com.daily.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tbl_talk
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class Talk implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_talk.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   关联商品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_talk.shop_id
     *
     * @mbggenerated
     */
    private String shopId;

    /**
     * Database Column Remarks:
     *   类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_talk.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * Database Column Remarks:
     *   评论标题
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_talk.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * Database Column Remarks:
     *   评论内容
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_talk.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * Database Column Remarks:
     *   评论人名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_talk.create_user_name
     *
     * @mbggenerated
     */
    private String createUserName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_talk.create_time
     *
     * @mbggenerated
     */
    private Date createTime;
    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_talk.star
     *
     * @mbggenerated
     */
    private Integer star;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_talk.dislike
     *
     * @mbggenerated
     */
    private Integer dislike;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_talk.id
     *
     * @return the value of tbl_talk.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_talk.id
     *
     * @param id the value for tbl_talk.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_talk.shop_id
     *
     * @return the value of tbl_talk.shop_id
     *
     * @mbggenerated
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_talk.shop_id
     *
     * @param shopId the value for tbl_talk.shop_id
     *
     * @mbggenerated
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_talk.type
     *
     * @return the value of tbl_talk.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_talk.type
     *
     * @param type the value for tbl_talk.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_talk.title
     *
     * @return the value of tbl_talk.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_talk.title
     *
     * @param title the value for tbl_talk.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_talk.content
     *
     * @return the value of tbl_talk.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_talk.content
     *
     * @param content the value for tbl_talk.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_talk.create_user_name
     *
     * @return the value of tbl_talk.create_user_name
     *
     * @mbggenerated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_talk.create_user_name
     *
     * @param createUserName the value for tbl_talk.create_user_name
     *
     * @mbggenerated
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_talk.create_time
     *
     * @return the value of tbl_talk.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_talk.create_time
     *
     * @param createTime the value for tbl_talk.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_talk.star
     *
     * @return the value of tbl_talk.star
     *
     * @mbggenerated
     */
    public Integer getStar() {
        return star;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_talk.star
     *
     * @param star the value for tbl_talk.star
     *
     * @mbggenerated
     */
    public void setStar(Integer star) {
        this.star = star;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_talk.dislike
     *
     * @return the value of tbl_talk.dislike
     *
     * @mbggenerated
     */
    public Integer getDislike() {
        return dislike;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_talk.dislike
     *
     * @param dislike the value for tbl_talk.dislike
     *
     * @mbggenerated
     */
    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "id='" + id + '\'' +
                ", shopId='" + shopId + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", star=" + star +
                ", dislike=" + dislike +
                '}';
    }
}