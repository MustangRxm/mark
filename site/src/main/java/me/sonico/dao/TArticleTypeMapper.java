package me.sonico.dao;

import me.sonico.bean.TArticleType;

public interface TArticleTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article_type
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long articleTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article_type
     *
     * @mbggenerated
     */
    int insert(TArticleType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article_type
     *
     * @mbggenerated
     */
    int insertSelective(TArticleType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article_type
     *
     * @mbggenerated
     */
    TArticleType selectByPrimaryKey(Long articleTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TArticleType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TArticleType record);
}