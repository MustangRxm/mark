package me.sonico.logic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import me.sonico.bean.TArticle;
import me.sonico.dao.ArticleMapper;
import me.sonico.dao.TArticleMapper;
import me.sonico.utils.Constant;
import me.sonico.utils.Log;

import static javafx.beans.binding.Bindings.select;


/**
 * @author Jack
 * @time 2016/11/6 0006 21:21
 * @des TODO
 */
@Service("articleLogic")
public class ArticleLogic {
    @Autowired
    private TArticleMapper mTArticleMapper;
    @Autowired
    private Log log;
//    @Autowired
//    public Constant constant;
    @Value("${FORTEST}")
    public String FORTEST;

    @Value("${jdbc.username}")
    public String dbusername;

    @Autowired
    private ArticleMapper mArticleMapper;
//    public int insertArticle(TArticle article){
//
//       return  mTArticleMapper.insert(article);
//    }

    public TArticle selectArticle(long id){
       return mTArticleMapper.selectByPrimaryKey(id);
    }
    public Optional<List<TArticle>> selectArticleByPage(Integer page){
//        log.i("for tet",constant.fortest);
//        log.i("for tet",FORTEST);
//        log.i("for db",dbusername);
//        int i = 1/0;
System.err.println("in logic");
        Optional op =  Optional.of(mTArticleMapper.selectByPrimaryKeyByPage((page-1)* me.sonico.utils.Constant.PAGE_MAX, Constant.PAGE_MAX));
        log.i("in logic ", Arrays.asList(op.orElse(Lists.newArrayList())).toString());
        return op;
    }

    public void query(){
        //使用所有组件时要注意，通用mapper所有组件包括包名，配置方式，全变
        PageHelper.startPage(5,5);
        List<TArticle> list =mArticleMapper.select(null);
        PageInfo pageInfo = new PageInfo(list);
//        mArticleMapper.s
        System.out.println();
    }
}
