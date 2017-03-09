package me.sonico.utils;

import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.qiniu.util.Json;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yanfa_4 on 2016-11-18.
 */
public class JsonUtil {
//    private static Gson gson = new Gson();
static Gson gson = new GsonBuilder()
        /**注册这个Map<String, Object>类型
         * http://blog.csdn.net/liangrui_cust/article/details/51197974
         */
        .registerTypeAdapter(  new TypeToken<List<Object>>(){}.getType(),
                new JsonDeserializer<List<Object>>() {
            @Override
            public List<Object> deserialize(JsonElement jsonElement, Type type,
                                            JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                List<Object> list = new ArrayList<>();
//                JsonObject jsonObject = jsonElement.getAsJsonObject();
                JsonArray jsonObject =   jsonElement.getAsJsonArray();
                Stream.of(jsonObject).parallel().forEach(x->list.add(x));
//                Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
//                entrySet.parallelStream().forEach((k)->  list.add(k.getValue()));
                return list;
            }
        })
        .registerTypeAdapter(
                new TypeToken<Map<String, Object>>(){}.getType(),
                new JsonDeserializer<Map<String, Object>>() {
                    @Override
                    public Map<String, Object> deserialize(
                            JsonElement json, Type typeOfT,
                            JsonDeserializationContext context) throws JsonParseException {
                        Map<String, Object> treeMap = new HashMap<>();
                        JsonObject jsonObject = json.getAsJsonObject();
                        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                        entrySet.parallelStream().forEach((k)->  treeMap.put(k.getKey(),k.getValue()));
//                        for (Map.Entry<String, JsonElement> entry : entrySet) {
//                            treeMap.put(entry.getKey(), entry.getValue());
//                        }
                        return treeMap;
                    }
                }
                ).create();
    private static Type MapType = new TypeToken<Map<String, Object>>() {
    }.getType();
    private static Type ListType = new TypeToken<List<Object>>() {
    }.getType();

    public static String toJson(Object obj){
        Preconditions.checkNotNull(obj,"需要转换为Json的对象不能为空");
        return gson.toJson(obj);
    }
    public  static <T> T fromJson(String json, Class<T> classOfT ){
        return gson.fromJson(json,classOfT);
    }

    public static Map getMapFromJson(String json){
//        Type MapType = new TypeToken<Map<K,V>>() {
//        }.getType();
       return  gson.fromJson(json,MapType);
    }
    public static List getListFromJson(String json){

        return  gson.fromJson(json,ListType);
    }

}
