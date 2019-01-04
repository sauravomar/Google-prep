package com.prep.arrays;

import java.util.ArrayList;
import java.util.List;

public class R {
  static String find_path(List<List<String>> matrix, String target_string) {
    return findPath(matrix, -1, 0, target_string);
  }


  private static String findPath(List<List<String>> matrix, int row, int col,
      String target_string) {

    if(target_string.length() == 0) return "";
    
    String res = null;
    String append = null;

    if (target_string.length() > 1) {
      if (matrix.get(row + 1).get(col).charAt(0) == target_string.charAt(0)) {

        res = findPath(matrix, row + 1, col,
            target_string.substring(1, (target_string.length() - 1)));
        append = "R";
      } else if (matrix.get(row).get(col + 1).charAt(0) == target_string.charAt(0)) {
        res = findPath(matrix, row, col + 1,
            target_string.substring(1, (target_string.length() - 1)));
        append = "D";
      } else {
        append = "NO PATH";
      }
    } else {
      if (matrix.get(row + 1).get(col).charAt(0) == target_string.charAt(0)) {
        append = "R";
      } else if (matrix.get(row).get(col + 1).charAt(0) == target_string.charAt(0)) {
        append = "D";
      } else {
        append = "NO PATH";
      }
    }

    if (append != "NO PATH" && res != "NO PATH") {
      return append + res;
    }

    return "NO PATH";
  }

  public static void main(String[] args) {
    List<String>list1 = new ArrayList<String>();
    list1.add("a"); list1.add("b"); list1.add("j"); list1.add("d");
    List<String>list2 = new ArrayList<String>();
    list2.add("n"); list2.add("j"); list2.add("k"); list2.add("m");
    List<String>list3 = new ArrayList<String>();
    list3.add("e"); list3.add("f"); list3.add("q"); list3.add("j");
    List<String>list4 = new ArrayList<String>();
    list4.add("a"); list4.add("b"); list4.add("j"); list4.add("d");
    
    
    List<List<String>> matrix = new ArrayList<List<String>>();
    matrix.add(list1);
    matrix.add(list2);
    matrix.add(list3);
    
    System.out.println(find_path(matrix, "abjfqz"));
    
  }
  

}
