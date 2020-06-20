import org.junit.Test;
import site.dunhanson.utils.basic.ObjectUtils;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtilsTest {
    @Test
    public void start() {
        // map
        Map<String, Object> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        // bytes
        byte[] bytes = ObjectUtils.toByteArray(map);
        // types to map
        map = ObjectUtils.toEntity(bytes);
        // print
        System.out.println(map);
    }
}
