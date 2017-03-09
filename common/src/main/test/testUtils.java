import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.sun.istack.internal.Nullable;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import me.sonico.utils.FieldFilter;
import me.sonico.utils.FileManage;
import me.sonico.utils.JsonUtil;
import me.sonico.utils.Log;

/**
 * @author Jack
 * @time 2016/11/8 0008 1:17
 * @des TODO
 */
public class testUtils {
    @Test
    public void testUpload() {
        FileManage fm = new FileManage();
        fm.upLoadFile("D:\\code\\WEB\\MustangSite\\site\\src\\main\\webapp\\\\upload\\JavaWeb.md", "jb.md");
    }

    @Test
    public void testJson() {
        List<Integer> list = Lists.newArrayList();
        list.add(2);
        list.add(23);
        list.add(22);
        list.add(211);
//    TypeToken<List<Integer>> listTypeToken = new TypeToken<List<Integer>>(){};
    }
public @interface author{}
    @Test
    public void testFilterIfExist() {
        String[] member = {"id", "age", "name"};
        Gson gson = new Gson();
        List<String> memberList = Lists.newArrayList();
        memberList.add("id");
        memberList.add("name");
//        memberList.add("id");
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", "ad");
        map.put("name", "sass");
        map.put("name11", "sass");

//        map.put("id","ad");

        try {
            FieldFilter.filterIfExist(gson.toJson(map), member, new Log(), new String[]{"id"});
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getSuppressed());
        }

    }


    @Test
    public void testLog(){
//        Log.i("tt","dfsfsf");
        System.out.println(System.getProperty("user.dir"));
      String[] str=   System.getProperty("user.dir").split("\\\\");
        System.out.println("size "+str.length);
        System.out.println(str[str.length-1]);
//        Arrays.stream(str).forEach(System.out::println);
    }

    @Test
    public void testTime(){
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(OffsetDateTime.now());
        System.out.println(OffsetTime.now());
        System.out.println(Year.now());
        System.out.println(Month.MAY);
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemUTC().millis());

        //使用DateTimeFormatter API 解析 和 格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime d6 = LocalDateTime.parse("2013/12/31 23:59:59", formatter);
        System.out.println(formatter.format(d6));

    }


    public void testLock(){
//        ReadWriteLock readWriteLock = new ReadWriteLock() {
//            @Override
//            public Lock readLock() {
//                return null;
//            }
//
//            @Override
//            public Lock writeLock() {
//                return null;
//            }
//        }
    }

    @Test
    public void test6(){
        List<Object> list1 = Lists.newArrayList();
        List<String> list2 = Lists.newArrayList();
        list1.addAll(list2);
    }

    @Test
    public void testJsonUtils(){
        HashMap<String,Object> map = Maps.newHashMap();
        map.put("da","ol");
        map.put("dadaa",1);
        map.put("dada",122.01f);
        map.put("daaaa",122);
////        map.put("daa",122.01f);
//        String json = JsonUtil.toJson(map);
//        System.out.println(json);
//        Map<String,Integer> map1 = JsonUtil.getMapFromJson(json);
//        System.out.println(map1);
//
//        List list = new ArrayList<>();
        LinkedList list = new LinkedList();
        list.add(map);
        list.add("dsaa");
        list.add(1);
        list.add(12.03f);
        list.add(1222l);
        String json = JsonUtil.toJson(list);
        System.out.println(json);
        List list1 = JsonUtil.getListFromJson(json);
//        List list1 = JsonUtil.fromJson(json,List.class);
        list1.forEach(System.out::println);

    }

    @Test
    public void test7() throws InterruptedException {
ThreadLocal<Long> t = new ThreadLocal<Long>(){
    @Override
    protected Long initialValue() {
        return System.nanoTime();
    }
};
      Thread th =   new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.err.println("now is "+t.get());
                    t.set(System.nanoTime());
                    System.err.println("first time set="+t.get());
                    //                    t.remove();
                    Thread.sleep(20);
                    System.err.println("final is "+t.get());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        th.start();
        th.join();

    }

    @Test
    public void test8(){
//        Preconditions.checkArgument(true,"%s ","dd");
        long start = System.nanoTime();
//        String st = format("%s %s","test","test");//159074 159502
//        String st = "test"+"test";//5132 5987
        StringBuilder sb = new StringBuilder();
        String st = sb.append("test").append("test").toString();//87663
        long end = System.nanoTime();
        System.err.println(end-start);

    }
    @Test

    public void test9(){
               Long test = 0l;
//        ThreadLocal<Long> test = new ThreadLocal<Long>(){
//            @Override
//            protected Long initialValue() {
//                return 0l;
//            }
//        };
        long start = System.nanoTime();
        for(int i =0;i<100;i++){
            Long s = test;
            s = s+1;
//            Long s = test.get();
//            test.set(s+1);
        }
        long end = System.nanoTime();

        System.err.println(end-start);
    }
    static String format(String template, @Nullable Object... args) {
        template = String.valueOf(template);
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;

        int i;
        int placeholderStart;
        for(i = 0; i < args.length; templateStart = placeholderStart + 2) {
            placeholderStart = template.indexOf("%s", templateStart);
            if(placeholderStart == -1) {
                break;
            }

            builder.append(template, templateStart, placeholderStart);
            builder.append(args[i++]);
        }

        builder.append(template, templateStart, template.length());
        if(i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);

            while(i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }

            builder.append(']');
        }

        return builder.toString();
    }
}
