# basic-utils

基础工具类



## GsonUtils

```java
@Test
public void start() {
    // map
    Map<String, Object> map = new HashMap<>();
    map.put("a", "aaa");
    map.put("b", "bbb");
    System.out.println(GsonUtils.gson.toJson(map));
}
```



## ObjectUtils

```java
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
```



## YamlUtils

```java
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
```

