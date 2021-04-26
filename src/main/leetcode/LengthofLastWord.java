package main.leetcode;

public class LengthofLastWord {


    public int lengthOfLastWord(String s) {


        if(s.length() == 0 || s.trim().length() == 0) return 0;

        String arr [] = s.split("\\s");



        if(arr[arr.length-1].trim().length() ==0) return 0;
        else return  arr[arr.length-1].trim().length();
    }

    public static void main(String[] args) {
        System.out.println(new LengthofLastWord().lengthOfLastWord("Hello World "));
    }
}
