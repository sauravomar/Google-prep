package main.klarna;

import java.util.*;

public class Shopping {

    static List<String> popularShoppingCategories(Map<String, List<String>> usersPurchases) {


        HashMap<String, List<String>> acceosories = new HashMap<>();


        List<String> list = new ArrayList<>();
        list.add("Clothing");

        acceosories.put("shirt", list);
        acceosories.put("sweater", list);
        acceosories.put("jacket", list);

        list = new ArrayList<>();
        list.add("Clothing");
        list.add("Sports");

        acceosories.put("shoes", list);
        acceosories.put("shorts", list);


        list = new ArrayList<>();
        list.add("Sports");

        acceosories.put("socks", list);
        acceosories.put("football", list);
        acceosories.put("helmet", list);

        list = new ArrayList<>();
        list.add("Sports");
        list.add("Accessories");

        acceosories.put("bag", list);

        list = new ArrayList<>();
        list.add("Accessories");

        acceosories.put("belt", list);
        acceosories.put("hat", list);
        acceosories.put("sunglasses", list);
        acceosories.put("watch", list);


        list = new ArrayList<>();
        list.add("Electronics");


        acceosories.put("tv", list);
        acceosories.put("camera", list);
        acceosories.put("headphones", list);
        acceosories.put("laptop", list);


        List<String> result = new ArrayList<>();

        HashMap<String, Integer> resultMap = new HashMap<>();

        for (Map.Entry<String, List<String>> listEntry : usersPurchases.entrySet()) {

            for (String str : listEntry.getValue()) {
                if (str.length() == 0) continue;
                if (!acceosories.containsKey(str.toLowerCase())) {
                    throw new IllegalArgumentException();
                }
                for (String key : acceosories.get(str.toLowerCase())) {
                    resultMap.put(key, resultMap.getOrDefault(key, 0) + 1);
                }
            }
        }
        resultMap = sortByValue(resultMap);

        int freq = 0;

        for (Map.Entry<String, Integer> listEntry : resultMap.entrySet()) {

            if (freq == 0) {
                freq = listEntry.getValue();
            }
            if (freq == listEntry.getValue()) result.add(listEntry.getKey());
        }
        Collections.sort(result);
        return result;
    }


    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {

        Map<String, List<String>> map = new HashMap<>();

        List<String> list = new ArrayList<>();
        list.add("Football");
        list.add("Shirt");
        list.add("Shoes");
        list.add("headphones");

        map.put("Michael", list);

        list = new ArrayList<>();
        list.add("TV");
        list.add("football");

        map.put("Sara", list);

        list = new ArrayList<>();
        list.add("shirt");
        list.add("sweater");
        list.add("");
        list.add("belt");
        list.add("bag");

        map.put("Daniel", list);

        System.out.println(popularShoppingCategories(map));

    }

}
