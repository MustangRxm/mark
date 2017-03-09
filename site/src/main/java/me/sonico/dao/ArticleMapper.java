package me.sonico.dao;


import me.sonico.bean.TArticle;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * @author Jack
 * @time 2016/12/16 0016 22:29
 * @des TODO
 */
public interface ArticleMapper extends Mapper<TArticle>, MySqlMapper<TArticle>,RowBoundsMapper<TArticle> {
}
