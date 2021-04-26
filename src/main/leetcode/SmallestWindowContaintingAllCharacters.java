package main.leetcode;

public class SmallestWindowContaintingAllCharacters {

   public String findSubString(String str, String pat){

       StringBuilder sb = new StringBuilder();

       if(pat.length() == 0 || str.length() == 0) return "";

       int patArr[] = new int[256];
       int strArr[] = new int[256];


       int start = 0;

       int minWindow  = str.length();
       int  start_index = -1;

       for(int i=0; i<pat.length(); i++){
           patArr[pat.charAt(i)]++;
       }

       int count = 0;

      for(int i=0; i<str.length(); i++){

          strArr[str.charAt(i)]++;

          if(patArr[str.charAt(i)] != 0 &&  strArr[str.charAt(i)] <= patArr[str.charAt(i)]){
              count++;
          }

          if(count == pat.length()) {
              while (strArr[str.charAt(start)] > patArr[str.charAt(start)]
                      || patArr[str.charAt(start)] == 0) {

                  if (strArr[str.charAt(start)] > patArr[str.charAt(start)])
                      strArr[str.charAt(start)]--;
                  start++;
              }


              int len_window = i - start + 1;
              if (minWindow > len_window) {
                  minWindow = len_window;
                  start_index = start;
              }
          }
      }
       if (start_index == -1)
       {
           System.out.println("No such window exists");
           return "";
       }
       return str.substring(start_index, start_index + minWindow);
   }

    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :\n " +
               new SmallestWindowContaintingAllCharacters().findSubString(str, pat));
    }
}
