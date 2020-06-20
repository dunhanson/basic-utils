package site.dunhanson.utils.basic;

import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author dunhanson
 * 2020.06.20
 * YAML工具类
 */
public class YamlUtils {
    // 配置存储库
    public static Map<String, Map<String, Object>> store = Collections.synchronizedMap(new HashMap<>());

    /**
     * 获取子节点Map对象
     * @param map
     * @param childKeys
     * @return 子节点Map指
     */
    public static Map<String, Object> getChildMap(Map<String, Object> map, String...childKeys) {
        Map<String, Object> childMap = map;
        for(String key : childKeys) {
            Object value = childMap.get(key);
            if(value instanceof Map) {
                childMap = (Map<String, Object>) value;
            }
        }
        return childMap;
    }

    /**
     * 获取子节点值
     * @param map
     * @param childKeys
     * @return Object对象
     */
    public static Object getChildValue(Map<String, Object> map, String...childKeys) {
        Object value = null;
        for(String key : childKeys) {
            value = map.get(key);
            if(value instanceof Map) {
                map = (Map<String, Object>) value;
            }
        }
        return value;
    }

    /**
     * 加载YAML文件
     * @param path
     * @return Map对象
     */
    public static Map<String, Object> load(String path) {
        Map<String, Object> value = store.get(path);
        if(value == null) {
            try(InputStream in = YamlUtils.class.getClassLoader().getResourceAsStream(path)) {
                value = new Yaml().load(in);
                store.put(path, value);
            } catch (Exception e) {
                throw new RuntimeException("can not load file path, " + e.getMessage());
            }
        }
        return value;
    }

    /**
     * 加载YAML文件,获取实体对象
     * @param path
     * @param type
     * @param <T>
     * @return 实体对象
     */
    public static <T> T load(String path, Class<T> type) {
        Gson gson = GsonUtils.gson;
        return gson.fromJson(gson.toJson(load(path)), type);
    }

    /**
     * 加载YAML文件,获取实体对象
     * @param path
     * @param type
     * @param <T>
     * @return 实体对象
     */
    public static <T> T load(String path, Type type) {
        Gson gson = GsonUtils.gson;
        return gson.fromJson(gson.toJson(load(path)), type);
    }

    /**
     * 加载YAML文件,获取实体对象,通过子节点key
     * @param path
     * @param type
     * @param childKeys
     * @param <T>
     * @return 实体对象
     */
    public static <T> T load(String path, Class<T> type, String...childKeys) {
        Gson gson = GsonUtils.gson;
        Map<String, Object> map = load(path);
        Object value = getChildValue(map, childKeys);
        String json = gson.toJson(value);
        return gson.fromJson(json, type);
    }

    /**
     * 加载YAML文件,获取实体对象,通过子节点key
     * @param path
     * @param type
     * @param childKeys
     * @param <T>
     * @return 实体对象
     */
    public static <T> T load(String path, Type type, String...childKeys) {
        Gson gson = GsonUtils.gson;
        Map<String, Object> map = load(path);
        Object value = getChildValue(map, childKeys);
        String json = gson.toJson(value);
        return gson.fromJson(json, type);
    }

    /**
     * 加载YAML文件,获取子节点值
     * @param path
     * @param childKeys
     * @return 子节点值
     */
    public static Object load(String path, String...childKeys) {
        return getChildValue(load(path), childKeys);
    }

}