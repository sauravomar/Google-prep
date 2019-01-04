package com.prep.arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Umbrellas {


  public static int getUmbrellas(int n, List<Integer> list) {
   
    if(n == 0) return -1;
    
    int min = Integer.MAX_VALUE;

    for (int val : list) {
      if ((n % val) == 0) {
        int currVal = (n / val);
        if (currVal < min) {
          min = currVal;
        }
      }
    }

    if (min == Integer.MAX_VALUE)
      return -1;
    else
      return min;
  }

  public static void main(String[] args) throws IOException {

    Scanner in = new Scanner(System.in);
    int numOfPeople = in.nextInt();
    int noOfChoices = in.nextInt();

    List<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < noOfChoices; i++) {
      list.add(in.nextInt());
    }

    System.out.println(getUmbrellas(numOfPeople, list));
  }
}
