package main.leetcode;

public class RemoveDuplicates {

    public String removeDuplicateLetters(String s) {

        boolean arr[] = new boolean[26];

        for(int i=0 ;i <s.length(); i++){
            arr[s.charAt(i) - 'a'] = true;
        }


        StringBuilder sb = new StringBuilder();

        for(int i=0 ;i <26; i++){
            if(arr[i]){
                sb.append( (char) ('a'+i ));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicateLetters("cbacdcbc"));
    }
}
