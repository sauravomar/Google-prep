package main.quince;


/*
Example
ab

aa ab, ba bb

 */

import java.util.ArrayList;
import java.util.List;

public class PossibleCharacters {

    public List<String> genertPossibleCombinattion(String str) {
        List<String> result = new ArrayList<>();
        if (str == null && str.length() == 0) return result;
        generate(str, "", result);
        return result;
    }

    private void generate(String str, String prev, List<String> result) {

        if (prev.length() == str.length()) {
            result.add(prev);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String currStr = prev + str.charAt(i);
            generate(str, currStr, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PossibleCharacters().genertPossibleCombinattion("abc").size()    );
    }

}
