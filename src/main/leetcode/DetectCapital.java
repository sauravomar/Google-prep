package main.leetcode;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {

        if(null == word || word.length() == 0)  return false;

        if(word.charAt(0) >= 65 && word.charAt(0) <= 90 ){

            if(word.length()> 1 && (word.charAt(1) >= 65 && word.charAt(1) <= 90)){
                return checkCap(word);
            }else if(word.length() ==1){
                return true;
            }else{
                return checkSmall(word.substring(1,word.length()));
            }
        }else{
            return checkSmall(word);
        }
    }



    public boolean checkSmall(String str){
        for(char ch: str.toCharArray()){
            if(ch < 97 || ch > 122) return false;
        }
        return true;
    }


    public boolean checkCap(String str){
        for(char ch: str.toCharArray()){
            if(ch < 65 || ch > 90) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUse("Leetcode"));
    }

}
