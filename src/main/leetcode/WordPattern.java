package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {

        Map<Character, String> map = new HashMap<>();

        String strArr[] = str.split("\\s+");

        if(strArr.length != pattern.length()) return  false;


        for(int i=0; i<strArr.length; i++){
            if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(strArr[i])){
                return  false;
            }else if(!map.containsKey(pattern.charAt(i)) && map.containsValue(strArr[i])){
                return  false;
            }
            else if(!map.containsKey(pattern.charAt(i)) ){
                map.put(pattern.charAt(i), strArr[i]);
            }
        }
        return  true;
    }


    public static void main(String[] args) {
       String pattern = "abba", str = "dog dog dog dog";


       System.out.println(new WordPattern().wordPattern(pattern, str));
    }

}
