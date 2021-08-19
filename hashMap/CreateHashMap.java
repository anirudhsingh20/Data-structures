package hashMap;

import java.util.HashMap;
import java.util.Set;

public class CreateHashMap {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 190);
        hm.put("China", 130);
        hm.put("US", 170);
        hm.put("UK", 150);
        hm.put("Canada", 110);

        System.out.println(hm);

        hm.put("India", 191);

        System.out.println(hm);

        Set<String> keys = hm.keySet();

        System.out.println(keys);

        for (String key : keys) {
            Integer val = hm.get(key);
            System.out.println(key + " : " + val);
        }
    }
}
