package test;

import hashmap.CustomHashMap;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomHashMapTest {

    @Test
    public void shouldPutAndGetValue() {
        CustomHashMap <String, Integer> map = new CustomHashMap<>();

        map.put("Aaa", 1);
        map.put("Ccc", 3);
        map.put(null, 10);
        map.put("Xxx",null);

        assertEquals(1, map.get("Aaa"));
        assertEquals(3, map.get("Ccc"));
        assertEquals(10, map.get(null));
        assertNull(map.get("Xxx"));
        assertEquals(4, map.sizeValue());
    }

    @Test
    public void shouldReplaceValueOfExistingKey() {
        CustomHashMap <String, Integer> map = new CustomHashMap<>();

        map.put("Aaa", 1);
        map.put("Aaa", 3);

        assertEquals(3, map.get("Aaa"));
        assertEquals(1, map.sizeValue());
    }

    @Test
    public void shouldRemoveValueAndKey() {
        CustomHashMap <String, Integer> map = new CustomHashMap<>();

        map.put("Aaa", 3);
        map.remove("Aaa");

        map.put(null, 10);
        map.remove(null);

        map.put("Xxx",null);
        map.remove("Xxx");

        assertNull(map.get("Aaa"));
        assertNull(map.get(null));
        assertNull(map.get("Xxx"));
        assertEquals(0, map.sizeValue());
    }

    @Test
    public void shouldResolveCollision() {
        CustomHashMap <String, Integer> map = new CustomHashMap<>();

        String key1 = "FB";
        String key2 = "Ea";

        assertEquals(key1.hashCode(), key2.hashCode());

        map.put("FB", 1);
        map.put("Ea", 2);

        assertEquals(1, map.get("FB"));
        assertEquals(2, map.get("Ea"));
        assertEquals(2, map.sizeValue());
    }
}
