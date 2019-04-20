import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("India", 1);
        treeMap.put("America", 2);
        treeMap.put("South Africa", 3);
        treeMap.put("Japan", 4);
        treeMap.put("Canada", 5);

        Set<Map.Entry<String, Integer>> set = treeMap.entrySet();

        for(String key: treeMap.keySet())
        {
            System.out.println(key +":" +treeMap.get(key));
        }


        String tempStr = "abcde";
        System.out.println(tempStr.substring(0,5));
    }
}


