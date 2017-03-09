package me.sonico.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import me.sonico.bean.TArticle;

public interface TArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long articleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated
     */
    int insert(TArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated
     */
    int insertSelective(TArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated
     */
    TArticle selectByPrimaryKey(Long articleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TArticle record);

    List<TArticle> selectByPrimaryKeyByPage(@Param("start") int start, @Param("end") int end);

    int insertArticleList(@Param("articleList")List<TArticle> articleList);
}