package me.sonico.utils;

/**
 * @author Jack
 * @time 2016/11/6 0006 21:39
 * @des TODO
 */
public class Constant {
    public static final Integer PAGE_MAX=5;
    //七牛的ACCESS_KEY和SECRET_KEY
    public static final String ACCESS_KEY="wwkrbXykMJr_o65cBv5vL24RrQPqNyCDgIny74Qn";
    public static final String SECRET_KEY ="A59U1Od0tdq5WZ647E8mkYhIlS6lqlmi1Wm8vD8p";
    //七牛的空间
    public static final String BUCKET_NAME="sonico";

    //日志配置
    public static final String LOG_SEPARATOR="|--|";
    public static final String SLF4J_FORMAT_WITH_TIME_LOGID = "logId={} {} method={}.{} {} time={} ms{} info={} {} data={}";
    public static final String SLF4J_FORMAT_WITHOUT_ANYTHING = "method={}.{} {} info={} {} data={}";
    public static final String SLF4J_FORMAT_WITH_LOGID = "logId= {} {} method={}.{} {} info={} {} data={}";
    public static final String SLF4J_FORMAT_WITH_TIME = "method={}.{} {} time={} ms {} info={} {} data={}";
    public static final short LOG_INFO = 0x01;
    public static final short LOG_DEBUG = 0x02;
    public static final short LOG_ERROR = 0x04;
    public static final short LOG_EXCEPTION = 0x08;


    /**
     * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700
     **/
    public static final String CHINA_TELECOM_PATTERN = "(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)";

    /**
     * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1709
     **/
    public static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)";

    /**
     * 中国移动号码格式验证
     * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184
     * ,187,188,147,178,1705
     **/
    public static final String CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";

    /**
     * 邮箱验证
     */
    public static final String EMAIL_PATTERN = "^([a-z0-9A-Z]*[-|_|\\.]*[a-z0-9A-Z]*)@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * ip验证
     */
    public static final String IP_PATTERN = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

    /**
     * 字段常量
     * /
     */

    //
    /**
     * 纯数字
     */
    public static final String Number = "([0-9]*)";
    /**id规定的长度*/
    public final static Integer ID_LENGTH = 16;
}
