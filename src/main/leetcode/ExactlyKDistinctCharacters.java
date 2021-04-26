package main.leetcode;

import java.util.Arrays;

public class ExactlyKDistinctCharacters {

  public static int countkDist(String str, int k){

      if(str.length() < k) return 0;
      int totalCount = 0;
      int cnt[] = new int[26];

      for(int i=0;i<str.length();i++){

          int count = 0;

          Arrays.fill(cnt, 0);

          for(int j=i;  j<str.length(); j++){

              if(cnt[str.charAt(j) - 'a'] == 0 && count < k){
                  cnt[str.charAt(j) - 'a']++;
                  count++;
              }else if (cnt[str.charAt(j) - 'a'] > 0){
                  cnt[str.charAt(j) - 'a']++;
              }

              if(count == k){
                  totalCount++;
              }
          }
      }
      return totalCount;
  }

    public static void main(String[] args) {
        String s = "aabbcc";
        int k = 1;
        System.out.println(countkDist(s, k));
    }
}
