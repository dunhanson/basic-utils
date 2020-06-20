import org.junit.Test;
import site.dunhanson.utils.basic.GsonUtils;
import java.util.HashMap;
import java.util.Map;

public class GsonUtilsTest {
    @Test
    public void start() {
        // map
        Map<String, Object> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        System.out.println(GsonUtils.gson.toJson(map));
    }
}
