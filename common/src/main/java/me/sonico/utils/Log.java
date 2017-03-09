package me.sonico.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by yanfa_4 on 2016-11-08.
 */
public class Log {
private  Logger loggerException = LoggerFactory.getLogger("exception");
    private Logger logger=null;
    private long lastCurrentTimeMillis = System.currentTimeMillis();
    private long time;
    public Log(){
            logger = LoggerFactory.getLogger(this.getClass());
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;

    }

    private String projectName;
    public Log(String projectName){
        this.projectName = projectName;//在applicationContext.xml中，使用bean构造器初始化
        logger = LoggerFactory.getLogger(this.projectName);
    }
    /**
     * i
     * Description 打印info级别日志(无时间统计,无logId)
     *
     * @param tag  打印的tag
     * @param data 数据
     */

    public void i(String tag, String data) {
//        if (logger.isInfoEnabled()) {
//            long start = System.nanoTime();
        logger.info(Constant.SLF4J_FORMAT_WITHOUT_ANYTHING, Thread.currentThread().getStackTrace()[2].getClassName(),  Thread.currentThread().getStackTrace()[2].getMethodName(), Constant.LOG_SEPARATOR, tag, Constant.LOG_SEPARATOR, data.toString());
//            print(logger, Constant.LOG_INFO, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
//        }
//        long  stop = System.nanoTime();
//        System.err.println("in i : "+(stop-start));
//        ThreadLocal t = new ThreadLocal();
//        t.
    }

    /**
     * i
     * Description 打印info级别日志(无时间统计)
     *
     * @param logId 日志id
     * @param tag   打印的tag
     * @param data  数据
     */
    public void i(Long logId, String tag, String data) {
        if (logger.isInfoEnabled()) {
            print(logger, Constant.LOG_INFO, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
        }
    }

    /**
     * i
     * Description 打印info级别日志(无日志id)
     *@deprecated 只能在单例模式下使用，多线程下时间统计有可能不安全
     * @param tag      打印的tag
     * @param data     数据
     * @param timeFlag 时间统计标志位,当timeFlag=true时,自动统计距离最近一个timeFlag为false的log的时间
     */
    public void i(String tag, String data, Boolean timeFlag) {
        if (!timeFlag) this.lastCurrentTimeMillis = System.currentTimeMillis();
        else time = System.currentTimeMillis() - lastCurrentTimeMillis;
        if (logger.isInfoEnabled()) {
            print(logger, Constant.LOG_INFO, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
    }

    /**
     * i
     * Description 打印info级别日志()
     *@deprecated 只能在单例模式下使用，多线程下时间统计有可能不安全
     * @param logId    日志id
     * @param tag      打印的tag
     * @param data     数据
     * @param timeFlag 时间统计标志位,当timeFlag=true时,自动统计距离最近一个timeFlag为false的log的时间
     */
    public void i(Long logId, String tag, String data, Boolean timeFlag) {
        if (!timeFlag) this.lastCurrentTimeMillis = System.currentTimeMillis();
        else time = System.currentTimeMillis() - lastCurrentTimeMillis;
        if (logger.isInfoEnabled()) {
            print(logger, Constant.LOG_INFO, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
    }
    /**
     * i
     * Description 打印info级别日志()
     *
     * @param logId    日志id
     * @param tag      打印的tag
     * @param data     数据
     */
    public void i(Long logId, String className,String method,String tag, String data) {
        if (logger.isInfoEnabled()) {
            print(logger, Constant.LOG_INFO, Constant.LOG_SEPARATOR, logId, className, method, tag, data);
        }
    }
    /**
     * i
     * Description 打印info级别日志()
     *
     * @param logId    日志id
     * @param tag      打印的tag
     * @param data     数据
     * @param time
     */
    public void i(Long logId, String className,String method,String tag, String data, long time) {
        if (logger.isInfoEnabled()) {
            print(logger, Constant.LOG_INFO, Constant.LOG_SEPARATOR, logId, className, method, tag, data, time);
        }
    }
    /**
     * d
     * Description 打印debug级别日志(无时间统计,无logId)
     *
     * @param tag  打印的tag
     * @param data 数据
     */
    public void d(String tag, String data) {
        if (logger.isDebugEnabled()) {
            print(logger, Constant.LOG_DEBUG, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
        }
    }

    /**
     * d
     * Description 打印debug级别日志(无时间统计)
     *
     * @param logId 日志id
     * @param tag   打印的tag
     * @param data  数据
     */
    public void d(long logId, String tag, String data) {
        if (logger.isDebugEnabled()) {
            print(logger, Constant.LOG_DEBUG, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
        }
    }

    /**
     * d
     * Description 打印debug级别日志(无日志)
     *@deprecated 只能在单例模式下使用，多线程下时间统计有可能不安全
     * @param tag      打印的tag
     * @param data     数据
     * @param timeFlag 时间统计标志位,当timeFlag=true时,自动统计距离最近一个timeFlag为false的log的时间
     */
    public void d(String tag, String data, boolean timeFlag) {
        if (!timeFlag) this.lastCurrentTimeMillis = System.currentTimeMillis();
        else time = System.currentTimeMillis() - lastCurrentTimeMillis;
        if (logger.isDebugEnabled()) {
            print(logger, Constant.LOG_DEBUG, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
    }

    /**
     * d
     * Description 打印debug级别日志()
     *@deprecated 只能在单例模式下使用，多线程下时间统计有可能不安全
     * @param logId    日志id
     * @param tag      打印的tag
     * @param data     数据
     * @param timeFlag 时间统计标志位,当timeFlag=true时,自动统计距离最近一个timeFlag为false的log的时间
     */
    public void d(long logId, String tag, String data, boolean timeFlag) {
        if (!timeFlag) this.lastCurrentTimeMillis = System.currentTimeMillis();
        else time = System.currentTimeMillis() - lastCurrentTimeMillis;
        if (logger.isDebugEnabled()) {
            print(logger, Constant.LOG_DEBUG, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
    }


    /**
     * d
     * Description 打印debug级别日志()
     *
     * @param logId    日志id
     * @param tag      打印的tag
     * @param data     数据
     * @param time
     */
    public void d(long logId, String className,String method,String tag, String data, long time) {
        if (logger.isDebugEnabled()) {
            print(logger, Constant.LOG_DEBUG, Constant.LOG_SEPARATOR, logId,className, method, tag, data, time);
        }
    }

    /**
     * e
     * Description 打印error级别日志(无日志，无时间)
     *
     * @param tag  打印的tag
     * @param data 数据
     */
    public void e(String tag, String data) {
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
        }
    }

    /**
     * e
     * Description 打印error级别日志(无时间统计)
     *
     * @param logId 日志id
     * @param tag   打印的tag
     * @param data  数据
     */
    public void e(long logId, String tag, String data) {
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
        }
    }
    /**
     * ex
     * Description 打印error级别日志(无日志id)
     *@deprecated 只能在单例模式下使用，多线程下时间统计有可能不安全
     * @param tag      打印的tag
     * @param data     数据
     * @param timeFlag 时间统计标志位,当timeFlag=true时,自动统计距离最近一个timeFlag为false的log的时间
     */
    public void e(String tag, String data, boolean timeFlag) {
        if (!timeFlag) this.lastCurrentTimeMillis = System.currentTimeMillis();
        else time = System.currentTimeMillis() - lastCurrentTimeMillis;
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
    }

    /**
     * e
     * Description 打印error级别日志
     *@deprecated 只能在单例模式下使用，多线程下时间统计有可能不安全
     * @param logId    日志id
     * @param tag      打印的tag
     * @param data     数据
     * @param timeFlag 时间统计标志位,当timeFlag=true时,自动统计距离最近一个timeFlag为false的log的时间
     */
    public void e(long logId, String tag, String data, boolean timeFlag) {
        if (!timeFlag) this.lastCurrentTimeMillis = System.currentTimeMillis();
        else time = System.currentTimeMillis() - lastCurrentTimeMillis;
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
    }
    /**
     * e
     * Description 打印error级别日志
     *
     * @param logId    日志id
     * @param tag      打印的tag
     * @param data     数据
     * @param time 时间统计标志位,当timeFlag=true时,自动统计距离最近一个timeFlag为false的log的时间
     */
    public void e(long logId, String className,String method,String tag, String data, long time) {
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, logId,className,method, tag, data, time);
        }
    }
    /**
     * ex
     * Description 打印异常级别日志(无日志，无时间)
     *
     * @param tag  打印的tag
     * @param data 数据
     */
    public void ex(String tag, String data) {
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
        }
        if (loggerException.isErrorEnabled()) {
            print(loggerException, Constant.LOG_EXCEPTION, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
        }
    }


    /**
     * ex
     * Description 打印异常级别日志(无时间统计)
     *
     * @param logId 日志id
     * @param tag   打印的tag
     * @param data  数据
     */
    public void ex(long logId, String tag, String data) {
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
        }
        if (loggerException.isErrorEnabled()) {
            print(loggerException, Constant.LOG_EXCEPTION, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data);
        }
    }

    /**
     * ex
     * Description 打印异常级别日志(无日志id)
     *@deprecated 感觉异常日志不需要统计时间
     *
     * @param tag      打印的tag
     * @param data     数据
     * @param timeFlag 时间统计标志位,当timeFlag=true时,自动统计距离最近一个timeFlag为false的log的时间
     */
    public void ex(String tag, String data, boolean timeFlag) {
        if (!timeFlag) this.lastCurrentTimeMillis = System.currentTimeMillis();
        else time = System.currentTimeMillis() - lastCurrentTimeMillis;
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
        if (loggerException.isErrorEnabled()) {
            print(loggerException, Constant.LOG_EXCEPTION, Constant.LOG_SEPARATOR, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
    }


    /**
     * ex
     * Description 打印异常级别日志
     *@deprecated 只能在单例模式下使用，多线程下时间统计有可能不安全
     * @param logId    日志id
     * @param tag      打印的tag
     * @param data     数据
     * @param timeFlag 时间统计标志位,当timeFlag=true时,自动统计距离最近一个timeFlag为false的log的时间
     */
    public void ex(long logId, String tag, String data, boolean timeFlag) {
        if (!timeFlag) this.lastCurrentTimeMillis = System.currentTimeMillis();
        else time = System.currentTimeMillis() - lastCurrentTimeMillis;
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
        if (loggerException.isErrorEnabled()) {
            print(loggerException, Constant.LOG_EXCEPTION, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
    }
    public void ex(long logId, String className,String method,String tag, String data, long time) {
        if (logger.isErrorEnabled()) {
            print(logger, Constant.LOG_ERROR, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
        if (loggerException.isErrorEnabled()) {
            print(loggerException, Constant.LOG_EXCEPTION, Constant.LOG_SEPARATOR, logId, Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), tag, data, time);
        }
    }


    /**
     * logId + time
     *
     * @param logger       slf4j logger
     * @param level        日志等级 在Constant常量表中
     * @param logSeparator 日志分隔符
     * @param logId        日志id
     * @param className    类名
     * @param methodName   方法名
     * @param tag          日志tag
     * @param data         日志数据
     * @param time         时间
     */
    private void print(Logger logger, short level, String logSeparator, long logId, String className, String methodName, String tag, String data, long time) {
        switch (level) {
//            public static final String SLF4J_FORMAT_WITH_TIME_LOGID = "logId={} {} method={}.{} {} time={} ms{} info={} {} data={}"
            case Constant.LOG_INFO:
                logger.info(Constant.SLF4J_FORMAT_WITH_TIME_LOGID,
                        logId, logSeparator, className,methodName, logSeparator, time,   logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_DEBUG:
                logger.debug(Constant.SLF4J_FORMAT_WITH_TIME_LOGID,
                        logId, logSeparator, className, methodName, logSeparator, time,  logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_ERROR:
                logger.error(Constant.SLF4J_FORMAT_WITH_TIME_LOGID,
                        logId, logSeparator, className, methodName, logSeparator, time,  logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_EXCEPTION:
                loggerException.error(Constant.SLF4J_FORMAT_WITH_TIME_LOGID,
                        logId, logSeparator, className,  methodName, logSeparator, time, logSeparator, tag, logSeparator, data.toString());

            default:
                break;
        }
    }

    /**
     * 只有logId
     *
     * @param logger       slf4j logger
     * @param level        日志等级 在Constant常量表中
     * @param logSeparator 日志分隔符
     * @param logId        日志id
     * @param className    类名
     * @param methodName   方法名
     * @param tag          日志tag
     * @param data         日志数据
     */
    private void print(Logger logger, short level, String logSeparator, long logId, String className, String methodName, String tag, String data) {
        switch (level) {
            //"logId= {} {} method={}.{} {} info={} {} data={}"
            case Constant.LOG_INFO:
                logger.info(Constant.SLF4J_FORMAT_WITH_LOGID,
                        logId, logSeparator, className,  methodName, logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_DEBUG:
                logger.debug(Constant.SLF4J_FORMAT_WITH_LOGID,
                        logId, logSeparator, className,  methodName, logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_ERROR:
                logger.error(Constant.SLF4J_FORMAT_WITH_LOGID,
                        logId, logSeparator,  className, methodName, logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_EXCEPTION:
                loggerException.error(Constant.SLF4J_FORMAT_WITH_LOGID,
                        logId, logSeparator,  className, methodName, logSeparator, tag, logSeparator, data.toString());
            default:
                break;
        }
    }

    /**
     * 只含有time
     *
     * @param logger       slf4j logger
     * @param level        日志等级 在Constant常量表中
     * @param logSeparator 日志分隔符
     * @param className    类名
     * @param methodName   方法名
     * @param tag          日志tag
     * @param data         日志数据
     * @param time         时间
     */
    private void print(Logger logger, short level, String logSeparator, String className, String methodName, String tag, String data, long time) {
        switch (level) {
            case Constant.LOG_INFO:
//                public static final String SLF4J_FORMAT_WITH_TIME = "method={}.{} {} time={} ms {} info={} {} data={}"
                logger.info(Constant.SLF4J_FORMAT_WITH_TIME,
                        className,  methodName, logSeparator, time, logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_DEBUG:
                logger.debug(Constant.SLF4J_FORMAT_WITH_TIME,
                        className,  methodName, logSeparator, time, logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_ERROR:
                logger.error(Constant.SLF4J_FORMAT_WITH_TIME,
                        className,  methodName, logSeparator, time, logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_EXCEPTION:
                loggerException.error(Constant.SLF4J_FORMAT_WITH_TIME,
                        className,  methodName, logSeparator, time, logSeparator, tag, logSeparator, data.toString());
            default:
                break;
        }
    }

    /**
     * 什么都没有
     *
     * @param logger       slf4j logger
     * @param level        日志等级 在Constant常量表中
     * @param logSeparator 日志分隔符
     * @param className    类名
     * @param methodName   方法名
     * @param tag          日志tag
     * @param data         日志数据
     */
    private void print(Logger logger, short level, String logSeparator, String className, String methodName, String tag, String data) {
        switch (level) {
            case Constant.LOG_INFO:
                logger.info(Constant.SLF4J_FORMAT_WITHOUT_ANYTHING, className,  methodName, logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_DEBUG:
                logger.debug(Constant.SLF4J_FORMAT_WITHOUT_ANYTHING,
                        className,  methodName, logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_ERROR:
                logger.error(Constant.SLF4J_FORMAT_WITHOUT_ANYTHING,
                        className,  methodName, logSeparator, tag, logSeparator, data.toString());
                break;
            case Constant.LOG_EXCEPTION:
                loggerException.error(Constant.SLF4J_FORMAT_WITHOUT_ANYTHING,
                        className,  methodName, logSeparator, tag, logSeparator, data.toString());
            default:
                break;
        }

    }

}
