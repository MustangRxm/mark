package me.sonico.utils;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import me.sonico.exception.FieldNoExistException;

/**
 * <p>Title: FieldFilter</p>
 * <p>Description: 字段过滤工具类，采用jdk8 lambda语法</p>
 * <p>Company: 广东今科道同科技股份有限公司</p>
 *
 * @author weijie.mai
 * @version 1.0
 * @date 2016年10月8日
 */
public class FieldFilter {
    private static Gson gson = new Gson();
    private static Type MapType = new TypeToken<Map<String, ?>>() {
    }.getType();

    /**
     * <p>Title: filterIfExist</p>
     * <p>Description:过滤除str数组外的字段 </p>
     *
     * @param json
     * @param str       需要保留的字段,但传入json中可能不含有该字段
     * @param log
     * @param necessary 必须有的字段
     * @return OperateResponse {data:Map<String,Object> 按str，筛选出json中存在的字段(key)与值(value)}
     */
    @SuppressWarnings("unchecked")
    public static OperateResponse filterIfExist(String json, String[] str, Log log, String[] necessary) throws FieldNoExistException {
        Map<String, Object> jsonMap;
        Preconditions.checkArgument(!Strings.isNullOrEmpty(json.trim()) && str.length != 0, "传入参数不能为空");
        jsonMap = gson.fromJson(json, MapType);
        Arrays.stream(necessary).parallel().forEach(key ->
                Preconditions.checkArgument(jsonMap.containsKey(key), "%s 字段不存在", key)
        );
        return filterIfExist(json, str, log);
    }

    /**
     * <p>Title: filterIfExist</p>
     * <p>Description:过滤除str数组外的字段 </p>
     *
     * @param json
     * @param str  需要保留的字段,但传入json中可能不含有该字段
     * @param log
     * @return OperateResponse {data:Map<String,Object> 按str，筛选出json中存在的字段(key)与值(value)}
     */
    @SuppressWarnings("unchecked")
    public static OperateResponse filterIfExist(String json, String[] str, Log log) {
        Map<String, Object> jsonMap;
        OperateResponse response;
        Map<String, Object> dataMap = Maps.newHashMap();
        Preconditions.checkArgument(!Strings.isNullOrEmpty(json.trim()) && str.length != 0, "传入参数不能为空");
        jsonMap = gson.fromJson(json, MapType);
        Preconditions.checkArgument(!jsonMap.isEmpty() || "{}".equals(json), "json转换错误");
        //过滤掉空的字段

        jsonMap.values().stream().parallel()
               .filter(t -> (Strings.isNullOrEmpty(t.toString()) || "null".equals(t.toString())));
        Arrays.asList(str).stream().forEach(key -> {
            if (jsonMap.containsKey(key)) {
                if (jsonMap.get(key) instanceof List) {
                    List list = Stream.of(jsonMap.get(key)).parallel().filter(t -> (Strings.isNullOrEmpty(t.toString().trim()) || "null".equals(t.toString()))).collect(Collectors.toList());
                    Preconditions.checkArgument(!list.isEmpty(), "%s 字段不能为空", key);
                    dataMap.put(key, jsonMap.get(key));
                } else {
                    dataMap.put(key, jsonMap.get(key));
                }
            }
        });
        response = new OperateResponse<>();
        response.setData(dataMap);
        response.setResult(ResponseResult.SUCCESS);
        return response;

    }

    /**
     * <p>Title: filter</p>
     * <p>Description:硬性过滤除str数组外的字段 </p>
     *
     * @param json
     * @param str  需要保留的字段
     * @param log
     * @return OperateResponse {data:Map<String,Object> 需要保留的字段(key)与值(value)}
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static OperateResponse filter(String json, String[] str, Log log) {
        Map<String, Object> jsonMap;
        OperateResponse response;
        Map<String, Object> dataMap = Maps.newHashMap();
        Preconditions.checkArgument(!Strings.isNullOrEmpty(json.trim()) && str.length != 0, "传入参数不能为空");
        jsonMap = gson.fromJson(json, MapType);
        Preconditions.checkArgument(!jsonMap.isEmpty() || "{}".equals(json), "json转换错误");
        //过滤掉空的字段
        jsonMap.values().stream()
               .filter(t -> (Strings.isNullOrEmpty(t.toString()) || "null".equals(t.toString())));
        Arrays.stream(str).parallel().forEach(key -> {
            // 有这个需要的字段
            Preconditions.checkArgument(jsonMap.containsKey(key), "%s 字段不存在", key);
            if (jsonMap.get(key) instanceof List) {
                List list = Stream.of(jsonMap.get(key)).parallel().filter(t -> (Strings.isNullOrEmpty(t.toString().trim()) || "null".equals(t.toString()))).collect(Collectors.toList());
                Preconditions.checkArgument(!list.isEmpty(), "%s list里面没有内容", key);
                dataMap.put(key, jsonMap.get(key));
            } else {
                dataMap.put(key, jsonMap.get(key));
            }
        });
        response = new OperateResponse<>();
        response.setData(dataMap);
        response.setResult(ResponseResult.SUCCESS);
        return response;
    }

}
