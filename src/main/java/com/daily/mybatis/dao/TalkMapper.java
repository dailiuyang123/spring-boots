package com.daily.mybatis.dao;

import com.daily.mybatis.entity.Talk;
import com.daily.mybatis.entity.TalkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_talk
     *
     * @mbggenerated
     */
    int countByExample(TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_talk
     *
     * @mbggenerated
     */
    int deleteByExample(TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_talk
     *
     * @mbggenerated
     */
    int insert(Talk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_talk
     *
     * @mbggenerated
     */
    int insertSelective(Talk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_talk
     *
     * @mbggenerated
     */
    List<Talk> selectByExample(TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_talk
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Talk record, @Param("example") TalkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_talk
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Talk record, @Param("example") TalkExample example);
}