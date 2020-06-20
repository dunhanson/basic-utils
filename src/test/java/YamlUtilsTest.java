import com.google.gson.reflect.TypeToken;
import entity.App;
import entity.Redis;
import org.junit.Test;
import site.dunhanson.utils.basic.YamlUtils;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class YamlUtilsTest {
    @Test
    public void start() {
        String path = "redis.yaml";
        Map<String, Object> map = YamlUtils.load(path);
        System.out.println(map);
    }

    @Test
    public void testByType() {
        String path = "baidu-ocr.yaml";
        Type type = new TypeToken<List<App>>(){}.getType();
        List<App> list = YamlUtils.load(path, type, "apps");
        System.out.println(list);
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
