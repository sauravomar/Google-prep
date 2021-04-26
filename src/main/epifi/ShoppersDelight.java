package main.epifi;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShoppersDelight {

    public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budgeted) {


        List<Integer> shoesAndJeans = new ArrayList<>();

        for (int i = 0; i < priceOfJeans.size(); i++) {
            for (int j = 0; j < priceOfShoes.size(); j++) {
                shoesAndJeans.add(priceOfJeans.get(i) + priceOfShoes.get(j));
            }
        }

        Collections.sort(shoesAndJeans);

        List<Integer> skirtsAndTop = new ArrayList<>();

        for (int i = 0; i < priceOfSkirts.size(); i++) {
            for (int j = 0; j < priceOfTops.size(); j++) {
                skirtsAndTop.add(priceOfSkirts.get(i) + priceOfTops.get(j));
            }
        }

        Collections.sort(skirtsAndTop, Collections.reverseOrder());

        long result = 0;
        int limit = 0;

        for (int cost : shoesAndJeans) {
            int remain = budgeted - cost;

            while (limit < skirtsAndTop.size() && skirtsAndTop.get(limit) < remain) {
                limit = limit + 1;
            }

            if (limit == skirtsAndTop.size()) break;

            result = result + skirtsAndTop.size() - limit;
        }
        return result;

    }

    public static void main(String[] args) throws IOException {

        List<Integer> priceOfJeans = new ArrayList<>();
        priceOfJeans.add(2);
        priceOfJeans.add(3);

        List<Integer> priceOfShoes = new ArrayList<>();
        priceOfShoes.add(4);

        List<Integer> priceOfSkirt = new ArrayList<>();
        priceOfSkirt.add(2);

        List<Integer> priceOfTops = new ArrayList<>();
        priceOfTops.add(1);
        priceOfTops.add(2);
        priceOfTops.add(3);

        System.out.println(ShoppersDelight.getNumberOfOptions(priceOfJeans,priceOfShoes,priceOfSkirt, priceOfTops, 10));

    }
}
