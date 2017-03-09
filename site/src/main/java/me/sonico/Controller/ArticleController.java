package me.sonico.Controller;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import me.sonico.bean.TArticle;
import me.sonico.logic.ArticleLogic;
import me.sonico.utils.Log;

/**
 * @author Jack
 * @time 2016/11/6 0006 22:57
 * @des TODO
 * http://blog.csdn.net/evankaka/article/details/45826697
 */


//@RestController
@Controller
//@ControllerAdvice //如果使用这个，需要在扫描包那里另外配置，否则不生效
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleLogic mArticleLogic;
    @Autowired
    private Log log;
    Gson gson = new Gson();



//    https://my.oschina.net/gxchan/blog/651301
    //不单单要在applicationContext.xml中声明，还要在sonico-servlet.xml中声明,详细看博客
@Value("${FORTEST}")
public String FORTEST;
//    @Autowired
//    private Constant constant;

   Cache<String,Object> caches = CacheBuilder.newBuilder()
            .expireAfterAccess(30, TimeUnit.SECONDS)
            .maximumSize(1000)
            .build();


    @RequestMapping(path = "/{articleId}", method = RequestMethod.GET)
    public WebAsyncTask selectArticle(@PathVariable("articleId") Long articleId) {
        WebAsyncTask<ModelAndView> wat =  new WebAsyncTask<>(()->{
        TArticle article = mArticleLogic.selectArticle(articleId);
        ModelAndView    modelAndView = new ModelAndView("/blog/single");
        modelAndView.addObject("article",article);
//        log.i("model and view ",modelAndView.toString());
        return modelAndView;
        });
        return wat;
//        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public WebAsyncTask selectArticleByPage(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) throws Exception {
        WebAsyncTask<ResponseEntity< List<TArticle>>> wat =  new WebAsyncTask<>(()->{
            System.err.println("s m test");
            caches.put("page",1+"");
            Optional< List<TArticle>> articleListOpt =  mArticleLogic.selectArticleByPage(page);
            if(!articleListOpt.isPresent()) System.err.println("articleListOpt null");
            List<TArticle> articleList =   articleListOpt.orElseThrow(()->new Exception("bean is empty"));
//                model.addAttribute("articleList", articleList);
            return  ResponseEntity.status(HttpStatus.OK).body(articleList);
        });
//        return ResponseEntity.status(HttpStatus.OK).body(articleList);
        return wat;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public  WebAsyncTask<ResponseEntity<String> >test() throws InterruptedException {
//    public  ResponseEntity<String> test() throws InterruptedException, ExecutionException {
        WebAsyncTask<ResponseEntity<String>> wat = new WebAsyncTask<>(new Callable<ResponseEntity<String>>() {
            @Override
            public ResponseEntity<String> call() throws Exception {
                System.err.println("in controller");
                Thread.sleep(10);
                System.out.println(String.format("the page is %s",Optional.ofNullable(caches.get("page",()->System.currentTimeMillis())).orElse("null")));
//                System.out.println(String.format("the page is %s",Optional.ofNullable(System.currentTimeMillis()).orElse(10086l)));
                return ResponseEntity.status(201).body("i am ok");
            }
        });


//        wat.onCompletion(()->{});
//        wat.onTimeout();
return wat;
//        Callable<String> str = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                System.err.println("i n run able");
//                return "test123456";
//            }
//        };
//        return str;
//        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(value = "/test1/{articleId}", method = RequestMethod.GET)
    public WebAsyncTask<ResponseEntity<String>> test1(@PathVariable("articleId") Long articleId) {
        WebAsyncTask<ResponseEntity<String>> wat = new WebAsyncTask<>(new Callable<ResponseEntity<String>>() {
            @Override
            public ResponseEntity<String> call() throws Exception {
                System.err.println("in controller");
caches.put("page",String.valueOf(articleId));
                return ResponseEntity.status(201).body("i am ok");
            }
        });
        return wat;}


    @RequestMapping(value = "/test", method = RequestMethod.PUT)
    public  WebAsyncTask<ResponseEntity<String> >testforput(String str,String key) throws InterruptedException {
        WebAsyncTask<ResponseEntity<String>> wat = new WebAsyncTask<>(new Callable<ResponseEntity<String>>() {
            @Override
            public ResponseEntity<String> call() throws Exception {
                System.err.println("in put"+"the str = "+str+" the key is "+key);
                return ResponseEntity.status(201).body("i am ok");
            }
        });
        return wat;
    }
    @RequestMapping(value = "/test", method = RequestMethod.DELETE)
    public  WebAsyncTask<ResponseEntity<String> >testfordelete(Integer i) throws InterruptedException {
        WebAsyncTask<ResponseEntity<String>> wat = new WebAsyncTask<>(new Callable<ResponseEntity<String>>() {
            @Override
            public ResponseEntity<String> call() throws Exception {
                System.err.println("in delete"+" id is "+i);
                return ResponseEntity.status(201).body("i am ok");
            }
        });
        return wat;
    }
    @RequestMapping(value = "/test", method = RequestMethod.PATCH)
    public  WebAsyncTask<ResponseEntity<String> >testforPATCH() throws InterruptedException {
        WebAsyncTask<ResponseEntity<String>> wat = new WebAsyncTask<>(new Callable<ResponseEntity<String>>() {
            @Override
            public ResponseEntity<String> call() throws Exception {
                System.err.println("in PATCH");
                return ResponseEntity.status(201).body("i am ok");
            }
        });
        return wat;
    }
}
