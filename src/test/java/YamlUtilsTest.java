import entity.Redis;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import site.dunhanson.utils.basic.YamlUtils;

import java.io.InputStream;
import java.util.Map;

public class YamlUtilsTest {
    @Test
    public void start() {
        String path = "redis.yaml";
        Map<String, Object> map = YamlUtils.load(path);
        System.out.println(map);
    }

    @Test
    public void testGetEntityByChildKeys() {
        String path = "redis.yaml";
        Redis redis = YamlUtils.load(path, Redis.class, "redis");
        System.out.println(redis);
    }

    @Test
    public void testGetValueByChildKeys() {
        String path = "redis.yaml";
        String[] childKeys = new String[]{"redis", "cluster", "sentinel", "masterName"};
        Object value = YamlUtils.load(path, childKeys);
        System.out.println(value);
    }
}
