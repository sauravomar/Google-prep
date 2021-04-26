package main.greedy;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list = new ArrayList<>();

        if (low > high) return list;
        int start = getFirstNumber(low);

        if (start < high) {
            list.add(start);
        }



        return list;
    }

    private int getFirstNumber(int low) {

        String str = new Integer(low).toString();
        StringBuilder sb = new StringBuilder();

        int start = 1;
        for (int i = 0; i < str.length(); i++) {
            sb.append(start);
            start++;
        }
        return Integer.parseInt(sb.toString());
    }

    private void recursiveGenerate(List<Integer>list, StringBuilder sb, int high){

    }
}