package com.daily.mybatis.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_article
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class ArticleWithBLOBs extends Article {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.articelTitle
     *
     * @mbggenerated
     */
    private String articelTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.articelContent
     *
     * @mbggenerated
     */
    private String articelContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.articelTitle
     *
     * @return the value of t_article.articelTitle
     *
     * @mbggenerated
     */
    public String getArticelTitle() {
        return articelTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.articelTitle
     *
     * @param articelTitle the value for t_article.articelTitle
     *
     * @mbggenerated
     */
    public void setArticelTitle(String articelTitle) {
        this.articelTitle = articelTitle == null ? null : articelTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.articelContent
     *
     * @return the value of t_article.articelContent
     *
     * @mbggenerated
     */
    public String getArticelContent() {
        return articelContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.articelContent
     *
     * @param articelContent the value for t_article.articelContent
     *
     * @mbggenerated
     */
    public void setArticelContent(String articelContent) {
        this.articelContent = articelContent == null ? null : articelContent.trim();
    }
}