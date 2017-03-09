package me.sonico.Controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author Jack
 * @time 2016/11/18 0018 23:16
 * @des TODO
 */
/**
 * 通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。
 * 注解了@Controller的类的方法可以使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上。
 *
 * @ControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上
 * @ExceptionHandler：用于全局处理控制器里的异常。
 * @InitBinder：用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。
 * @ModelAttribute：本来作用是绑定键值对到Model中，此处让全局的@RequestMapping都能获得在此处设置的键值对。
 */

/**
 * 未知
 */
//@Validated//校验
//SessionAttributes

/**
 * 1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，
 * 配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 例如：本来应该到success.jsp页面的，则其显示success.

 2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解
 */
//@Controller
//@RestController //相当于@ResponseBody ＋ @Controller合在一起的作用。
//@ControllerAdvice //辅助控制器,如果使用这个，需要在扫描包那里另外配置，否则不生效
//指定其只对一个子集的控制器生效
//@ControllerAdvice(annotations = RestController.class)
//@ControllerAdvice("org.example.controllers")
//@ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})

//@RequestMapping(value = "/demo")
//@SessionAttributes("currentUser")//将返回值放到currentUser(实体类bean)里面，然后又被存储到session里面
public class DemoController {
    // 定义全局异常处理，value属性可以过滤拦截条件，此处拦截所有的Exception
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorMessage", exception.getMessage());
        return mv;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String processUnauthenticatedException(NativeWebRequest request, Exception e) {
        System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出Exception异常(可自定义)时执行");
        return "viewName"; //返回一个逻辑视图名
    }


    // 此处将键值对添加到全局，注解了@RequestMapping的方法都可以获得此键值对
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外的信息");
    }

    //    @ModelAttribute("currentUser")
    //    @RequestMapping("/getUser.do")
    //    public String getUser() {
    //        User user = userService.getUser("liming");
    //        return user; //返回user到modelAttribute中
    //    }
    //    @RequestMapping("/getUser.do")
    //    public User getUser(@ModelAttribute("currentUser") User user) {
    //        String name = User.getName;
    //        String address = User.getAddress;
    //        User user = userService.getParent(name);
    //        return user;
    //    }


    @ModelAttribute
    public void 会在执行每个controller方法前运行的方法(Model model) {
        //        log.i("test", concurrent.currentThread().getStackTrace()[1].getMethodName());
        model.addAttribute("i am best");//执行完方法后，可以让它set回model，返回数据给前台
        //当有返回值时，会默认将该返回值set进model
    }

    // 此处仅演示忽略request中的参数id
    @InitBinder//在@ControllerAdvice中使用@InitBinder注解
    public void initBinder(WebDataBinder webDataBinder) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
        webDataBinder.setDisallowedFields("id");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("/displayHeaderInfo.do")
    public void displayHeaderInfo(@CookieValue("JSESSIONID") String cookie) {
        //...获取cookie的值
    }

    @RequestMapping("/displayHeaderInfo.do")
    public void displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding,//获取请求头的信息
                                  @RequestHeader("Keep-Alive") long keepAlive) {
        //...
    }

    /**
     * 视图接口
     * http://blog.csdn.net/isea533/article/details/40428179
     * http://www.jianshu.com/p/633d83dd303b (重点)
     * 其实就是类似一个标识的作用，使用注解在bean上标识那些需要序列化
     */
    //    @RequestMapping(path = "/user", method = RequestMethod.GET)
    //        @JsonView(User.WithoutPasswordView.class)
    //        public User getUser() {
    //            return new User("eric", "7!jd#h23");
    //    }

//    异步请求的处理

    @RequestMapping(method= RequestMethod.POST)
    public Callable<String> processUpload(final MultipartFile file) {
        //return ()->"someView";
        return new Callable<String>() {
            public String call() throws Exception {
                // ...
                return "someView";
            }
        };
    }
    //ResponseBodyEmitter 可被用于发送多个对象。 是不是有点像eventbus??
    // 通常我们所使用的@ResponseBody只能返回一个对象，它是通过HttpMessageConverter写到响应体中的。
    //据说可实现长连接推送,提供了对服务器端事件推送的技术的支持
    //SseEmitter是ResponseBodyEmitter的一个子类



    //spring-test模块对测试控制器@Controller提供了最原生的支持。详见14.6 "Spring MVC测试框架"一节。

    /**
     * 定时任务 @scheduled
     * http://fanshuyao.iteye.com/blog/2267243
     * http://blog.csdn.net/qq_33556185/article/details/51852537
     */


    /**
     * @Async 异步方法注解
     * http://blog.csdn.net/zhibo112/article/details/18500139
     * http://blog.csdn.net/ClementAD/article/details/47403185
     * http://www.jianshu.com/p/4e215285cb0a
     * http://fengchj.com/?p=2075
     */

    /**
     * StreamingResponseBody
     * 直接写回输出流OutputStream的HTTP Streaming
     */

    /**url地址构造
     * UriComponents  MvcUriComponentsBuilder
     */

    /**
     * 国际化
     * 21.8.1 获取时区信息
     * Accept请求头解析器AcceptHeaderLocaleResolver
     * Cookie解析器CookieLocaleResolver
     * Session解析器SessionLocaleResolver
     * 地区更改拦截器LocaleChangeInterceptor
     * http://www.xdemo.org/spring-i18n/
     * http://blog.lifw.org/post/26098052
     *但要注意，获得语言环境，可以通过请求头来获取，如文档21.8.1 所描述的，通过时区获取
     */

    /**
     * 异步调用http请求 AsyncRestTemplate
     */
}